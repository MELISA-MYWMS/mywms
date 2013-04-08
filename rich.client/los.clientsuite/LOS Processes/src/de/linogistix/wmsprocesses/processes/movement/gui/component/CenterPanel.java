/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.wmsprocesses.processes.movement.gui.component;

import de.linogistix.common.gui.component.controls.BOAutoFilteringComboBox;
import de.linogistix.common.gui.listener.TopComponentListener;
import de.linogistix.common.gui.component.controls.LOSDateFormattedTextField;
import de.linogistix.wmsprocesses.processes.movement.gui.gui_builder.AbstractCenterPanel;
import de.linogistix.common.services.J2EEServiceLocator;
import de.linogistix.common.services.J2EEServiceLocatorException;
import de.linogistix.common.userlogin.LoginService;
import de.linogistix.common.util.BusinessExceptionResolver;
import de.linogistix.common.util.CursorControl;
import de.linogistix.common.util.ExceptionAnnotator;
import de.linogistix.inventory.gui.component.controls.ClientItemDataLotFilteringComponent;
import de.linogistix.los.inventory.exception.InventoryException;
import de.linogistix.los.inventory.exception.InventoryExceptionKey;
import de.linogistix.los.inventory.facade.MovementOrderFacade;
import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.inventory.model.OrderType;

import de.linogistix.los.query.BODTO;
import de.linogistix.los.query.ClientQueryRemote;
import de.linogistix.wmsprocesses.lot.gui.component.LotOptionPanel;
import de.linogistix.wmsprocesses.res.WMSProcessesBundleResolver;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DateFormatter;
import org.mywms.facade.ZoneFacade;
import org.mywms.facade.VehicleDataFacade;
import org.mywms.facade.FacadeException;
import org.mywms.model.Client;
import org.mywms.model.ItemData;
import org.mywms.model.Lot;
import org.mywms.model.Zone;
import org.mywms.model.VehicleData;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

/**
 *
 * @author artur
 */
public class CenterPanel extends AbstractCenterPanel implements TopComponentListener {

    private J2EEServiceLocator loc = (J2EEServiceLocator) Lookup.getDefault().lookup(J2EEServiceLocator.class);
    private final static Logger log = Logger.getLogger(CenterPanel.class.getName());
    private boolean initialized = false;
    TopComponentPanel topComponentPanel;
    private BOAutoFilteringComboBox<VehicleData> vehicleDataComboBox = null;
    private BOAutoFilteringComboBox<LOSOrderReceipients> driverComboBox = null;

    public CenterPanel(TopComponentPanel topComponentPanel) {
        this.topComponentPanel = topComponentPanel;
        initDefaults();

    }

    void clear() {
        initDefaults();
    }

    private void clearPositionDetail() {
    }

    public void process(boolean processAutomaticly) {
        String formation = FormationComboBox.getSelectedItem().toString();
        String organization = OrganizationComboBox.getSelectedItem().toString();
        String militaryUnit = MillitaryUnitComboBox.getSelectedItem().toString();
        Date currDate = currentDateTextField.getDate();
        String vehicleType = VehicleTypeComboBox.getSelectedItem().toString();
        String plateNo = vehicleDataComboBox.getSelectedAsEntity().getPlateNumber();
        Date movementDate = MovementDateTextField.getDate();
        String orderNo = OrderNoFormattedTextField.getText();
        Long sequenceNumber = Long.parseLong(sequenceNumberTextField.getText());
        String movementPurpose = MovementPurposeTextField.getText();
        String movementLoad = MovementLoadTextField.getText();
        String movementRoute = MovementRouteTextField.getText();
        String driverName = driverComboBox.getSelectedAsEntity().getFirstName() + driverComboBox.getSelectedAsEntity().getLastName();
        String passenger1Name = Passenger1TextField.getText();
        String passenger2Name = Passenger2TextField.getText();
        String passenger3Name = Passenger3TextField.getText();
        String passenger4Name = Passenger4TextField.getText();


        Logger.getLogger(CenterPanel.class.getName()).info("---*--- Formation Text: " + formation);
        Logger.getLogger(CenterPanel.class.getName()).info("---*--- Organization Text: " + organization);
        Logger.getLogger(CenterPanel.class.getName()).info("---*--- Pass 3: " + passenger3Name);
        Logger.getLogger(CenterPanel.class.getName()).info("---*--- Date Text: " + currDate);
        Logger.getLogger(CenterPanel.class.getName()).info("---*--- VehicleTypeComboBox Text: " + vehicleType);
        Logger.getLogger(CenterPanel.class.getName()).info("---*--- Pass 2: " + passenger2Name);
        MovementOrderFacade mi;
        try {
            mi = (MovementOrderFacade) loc.getStateless(MovementOrderFacade.class);
        } catch (Exception ex) {
            ExceptionAnnotator.annotate(ex);
            return;
        }
        try {
            Logger.getLogger(CenterPanel.class.getName()).info("---*--- Movement created: " + mi.createMovementOrder(organization, formation, militaryUnit, sequenceNumber, currDate, plateNo, vehicleType, movementDate, orderNo, movementPurpose, movementRoute, movementLoad, driverName, passenger1Name, passenger2Name, passenger3Name, passenger4Name));
        } catch (FacadeException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void initDefaults() {
        LoginService login = Lookup.getDefault().lookup(LoginService.class);
        currentDateTextField.setDate(new Date());
        MovementDateTextField.setDate(new Date());
        OrganizationLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.OrganizationLabel") + ":");
        FormationLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.FormationLabel") + ":");
        MillitaryUnitLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.MillitaryUnitLabel") + ":");
        DateLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.DateLabel") + ":");
        SequenceNoLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.SequenceNumberLabel") + ":");
        VehicleTypeLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.VehicleTypeLabel") + ":");
        VehiclePlateNoLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.VehiclePlateNoLabel") + ":");
        MovementDateLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.MovementDateLabel") + ":");
        OrderNoLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.OrderNoLabel") + ":");
        MovementPurposeLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.MovementPurposeLabel") + ":");
        MovementLoadLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.MovementLoadLabel") + ":");
        MovementRouteLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.MovementRouteLabel") + ":");
        DriverNameLabel.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.DriverNameLabel") + ":");
        Passenger1Label.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.PassNameLabel") + ":");
        Passenger2Label.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.PassNameLabel") + ":");
        Passenger3Label.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.PassNameLabel") + ":");
        Passenger4Label.setText(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.PassNameLabel") + ":");

        OrganizationComboBox.removeAllItems();
        OrganizationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.HAFComboItem"));
        OrganizationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.HAComboItem"));
        OrganizationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.HNComboItem"));

        FormationComboBox.removeAllItems();
        FormationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.ATAComboItem"));
        FormationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.GEAComboItem"));
        FormationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.DAEComboItem"));
        FormationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.DAYComboItem"));
        FormationComboBox.addItem(NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.DAKComboItem"));

        MillitaryUnitComboBox.removeAllItems();
        List<Zone> MillitaryUnits = this.getMillitaryUnits();
        for (int i = 0; i < MillitaryUnits.size(); i++) {
            MillitaryUnitComboBox.addItem(MillitaryUnits.get(i).getName());
        }

        VehicleTypeComboBox.removeAllItems();
        List<VehicleData> vehicles = this.getVehicles();
        for (int i = 0; i < vehicles.size(); i++) {
            VehicleTypeComboBox.addItem(vehicles.get(i).getModelName());
        }
        initAutofiltering();
    }

    private void initAutofiltering() {
        getVehicleDataComboBox().setEnabled(true);
        getVehicleDataComboBox().setMandatory(true);
        getVehicleDataComboBox().setAlignmentX(CENTER_ALIGNMENT);
        //getVehicleDataComboBox().setEditorLabelTitle("Vehicle Data");

        getVehicleDataComboBox().addItemChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {

                VehicleData selVehicleData = getVehicleDataComboBox().getSelectedAsEntity();

                if (selVehicleData != null) {
                    VehicleTypeComboBox.setSelectedItem(selVehicleData.getModelName());
                } else {
//                    getAmountTextField().setEnabled(false);
                }
            }
        });

        getDriverComboBox().setEnabled(true);
        getDriverComboBox().setMandatory(true);
        getDriverComboBox().setAlignmentX(CENTER_ALIGNMENT);
        getDriverComboBox().addItemChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {

                LOSOrderReceipients selDriver = getDriverComboBox().getSelectedAsEntity();

                if (selDriver != null) {
                } else {
//                    getAmountTextField().setEnabled(false);
                }
            }
        });
    }

    private BOAutoFilteringComboBox<VehicleData> getVehicleDataComboBox() {
        if (vehicleDataComboBox == null) {
            vehicleDataComboBox = new BOAutoFilteringComboBox<VehicleData>(VehicleData.class);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 4, 10, 0);

            VehiclePanel.add(vehicleDataComboBox, gbc);
        }
        return vehicleDataComboBox;
    }

    private BOAutoFilteringComboBox<LOSOrderReceipients> getDriverComboBox() {
        if (driverComboBox == null) {
            driverComboBox = new BOAutoFilteringComboBox<LOSOrderReceipients>(LOSOrderReceipients.class);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new Insets(0, 4, 10, 0);

            PersonsPanel.add(driverComboBox, gbc);
        }
        return driverComboBox;
    }

    private List<Zone> getMillitaryUnits() {
        ZoneFacade ZoneF = null;
        List<Zone> zones = null;
        try {
            ZoneF = (ZoneFacade) loc.getStateless(ZoneFacade.class);
        } catch (J2EEServiceLocatorException ex) {
            Exceptions.printStackTrace(ex);
        }
        zones = ZoneF.getAllZones();
        return zones;
    }

    private List<VehicleData> getVehicles() {
        VehicleDataFacade VehicleF = null;
        List<VehicleData> vehicles = null;
        try {
            VehicleF = (VehicleDataFacade) loc.getStateless(VehicleDataFacade.class);
        } catch (J2EEServiceLocatorException ex) {
            Exceptions.printStackTrace(ex);
        }
        vehicles = VehicleF.getAllVehicles();
        return vehicles;
    }

    public void componentClosed() {
    }

    public void componentOpened() {
        if (initialized) {
            return;
        }
        initAutofiltering();
        initialized = true;
        clear();
    }

    public void componentActivated() {
    }

    public void componentDeactivated() {
    }

    public void componentHidden() {
    }

    public void componentShowing() {
    }
}
