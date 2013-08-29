/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.linogistix.wmsprocesses.processes.fuel.gui.component;

import de.linogistix.los.inventory.model.LOSFuelOrderLog;

import de.linogistix.common.gui.component.windows.ProgressDialog;
import de.linogistix.wmsprocesses.res.WMSProcessesBundleResolver;
import java.awt.Desktop;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.util.NbBundle;

/**
 *
 * @author Parhs Rozakhs
 */
public class PdfFuelReport extends Thread {

    private final static Logger log = Logger.getLogger(PdfFuelReport.class.getName());
    private List<LOSFuelOrderLog> fuelOrderLog;
    private Date logFrom, logTo;
    private ProgressDialog progDialog;
    private List<String> pdMessages;
    final ProgressHandle progrHandle = ProgressHandleFactory.createHandle("");

    public PdfFuelReport(List<LOSFuelOrderLog> myFuelOrderLog, Date from, Date to) {
        fuelOrderLog = myFuelOrderLog;
        logFrom = from;
        logTo = to;
        pdMessages = Arrays.asList(
                NbBundle.getMessage(WMSProcessesBundleResolver.class, "FuelOrderCenterPanel.creatingMessage"),
                NbBundle.getMessage(WMSProcessesBundleResolver.class, "FuelOrderCenterPanel.exportingMessage"),
                NbBundle.getMessage(WMSProcessesBundleResolver.class, "FuelOrderCenterPanel.openingMessage"));
        progDialog = ProgressDialog.getInstance();
    }

    @Override
    public void run() {
        progrHandle.start(100);
        progDialog.DialogShow();
        createFuelOrderLogReport();
    }

    public void createFuelOrderLogReport() {
        try {
            // load report location
            // fill report
            progrHandle.progress(10);
            progrHandle.setDisplayName(pdMessages.get(0));
            progDialog.setProgress(10, pdMessages.get(0));
            List<Map<String, ?>> maps = new ArrayList<Map<String, ?>>();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("LOS_DATE_FROM", logFrom);
            map.put("LOS_DATE_TO", logTo);
            maps.add(map);

            progrHandle.progress(20);
            progDialog.setProgress(20);
            JRBeanCollectionDataSource jbCollectionDS = new JRBeanCollectionDataSource(
                    fuelOrderLog);
            progrHandle.progress(30);
            progDialog.setProgress(30);
            // compile report
            JasperReport jasperReport =
                    JasperCompileManager.compileReport("reports/LOSFuelOrderLogReport.jrxml");
            progrHandle.progress(50);
            progrHandle.setDisplayName(pdMessages.get(1));
            progDialog.setProgress(50, pdMessages.get(1));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, jbCollectionDS);

            // view report to UI
            //JasperViewer.viewReport(jasperPrint, false);
            progrHandle.progress(80);
            progrHandle.setDisplayName(pdMessages.get(2));
            progDialog.setProgress(80, pdMessages.get(2));
            JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/LOSFuelOrderLogReport.pdf");
        } catch (JRException ex) {
            progrHandle.suspend("PDF Creation error");
            Logger.getLogger(PdfFuelReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        progrHandle.progress(90);
        progDialog.setProgress(90);
        OpenPdfReportFile();
        progDialog.setProgress(100);
        progrHandle.finish();
    }

    protected void OpenPdfReportFile() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File("reports/LOSFuelOrderLogReport.pdf"));
        } catch (IOException e) {
        }
    }
}
