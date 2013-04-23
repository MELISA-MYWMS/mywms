/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.linogistix.wmsprocesses.processes.movement.gui.component;

import de.linogistix.los.inventory.model.MovementOrderLog;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
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
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Date;

/**
 *
 * @author Parhs
 */
public class PdfReport extends Thread {

    private final static Logger log = Logger.getLogger(PdfReport.class.getName());
    protected String transactionId;
    protected String organization;
    protected String formation;
    protected String militaryUnit;
    protected Date currDate;
    protected String plateNo;
    protected String vehicleType;
    protected Date movementDate;
    protected String orderNo;
    protected String movementPurpose;
    protected String movementRoute;
    protected String movementLoad;
    protected String driverName;
    protected String driverID;
    protected String passenger1Name;
    protected String passenger2Name;
    protected String passenger3Name;
    protected String passenger4Name;

    public PdfReport(MovementOrderLog myOrder) {
        transactionId = myOrder.getTransactionId();
        organization = myOrder.getOrganization();
        formation = myOrder.getFormation().name();
        militaryUnit = myOrder.getMilitaryUnit().getName();
        currDate = myOrder.getCurrDate();
        plateNo = myOrder.getPlateNo();
        vehicleType = myOrder.getVehicleType();
        movementDate = myOrder.getMovementDate();
        orderNo = myOrder.getOrderNo();
        movementPurpose = myOrder.getMovementPurpose();
        movementRoute = myOrder.getMovementRoute();
        movementLoad = myOrder.getMovementLoad();
        driverName = myOrder.getDriver().getFirstName() + " " + myOrder.getDriver().getLastName();
        driverID = myOrder.getDriver().getId().toString();
        passenger1Name = myOrder.getPassenger1Name();
        passenger2Name = myOrder.getPassenger2Name();
        passenger3Name = myOrder.getPassenger3Name();
        passenger4Name = myOrder.getPassenger4Name();
        //createMovementOrderReport();
    }

    @Override
    public void run() {
        createMovementOrderReport();
    }

    public void createMovementOrderReport() {
        try {
            // load report location
            // fill report
            List<Map<String, ?>> maps = new ArrayList<Map<String, ?>>();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("transactionId", transactionId);
            map.put("Organization", organization);
            map.put("Formation", formation);
            map.put("MilitaryUnit", militaryUnit);
            map.put("orderNo", orderNo);
            map.put("currDate", currDate);
            map.put("PlateNo", plateNo);
            map.put("vehicleType", vehicleType);
            map.put("DriverName", driverName);
            if (!passenger1Name.isEmpty()) {
                map.put("passenger1Name", "Επιβάτης: " + passenger1Name);
            }
            if (!passenger2Name.isEmpty()) {
                map.put("passenger2Name", "Επιβάτης: " + passenger2Name);
            }
            if (!passenger3Name.isEmpty()) {
                map.put("passenger3Name", "Επιβάτης: " + passenger3Name);
            }
            if (!passenger4Name.isEmpty()) {
                map.put("passenger4Name", "Επιβάτης: " + passenger4Name);
            }
            map.put("movementDate", movementDate);
            map.put("movementPurpose", movementPurpose);
            map.put("movementLoad", movementLoad);
            map.put("movementRoute", movementRoute);
            ByteArrayInputStream QRStream = new ByteArrayInputStream(Str2QR(transactionId + plateNo + driverID));
            map.put("IDImage", QRStream);
            ByteArrayInputStream BrcdStream = new ByteArrayInputStream(Str2Brcd(plateNo));
            map.put("VehicleID", BrcdStream);
            ByteArrayInputStream BrcdStream2 = new ByteArrayInputStream(Str2Brcd(driverID));
            map.put("DriverID", BrcdStream2);
            maps.add(map);

            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(maps);

            // compile report
            JasperReport jasperReport =
                    JasperCompileManager.compileReport("reports/MovementOrder.jrxml");
            //JasperCompileManager.compileReport("LOSFuelOrderLogReport.jrxml");

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), dataSource);
            // view report to UI
            //JasperViewer.viewReport(jasperPrint, false);
            JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/report.pdf");
        } catch (JRException ex) {
            Logger.getLogger(PdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        OpenPdfReportFile();
    }

    private byte[] Str2QR(String Text) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = null;
        try {
            matrix = writer.encode(Text, BarcodeFormat.QR_CODE, 512, 512);
        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (matrix != null) {
            try {
                MatrixToImageWriter.writeToStream(matrix, "PNG", outStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return outStream.toByteArray();
    }

    private byte[] Str2Brcd(String Text) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        Code128Writer writer = new Code128Writer();
        BitMatrix matrix = null;
        try {
            matrix = writer.encode(Text, BarcodeFormat.CODE_128, 512, 200);
        } catch (WriterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (matrix != null) {
            try {
                MatrixToImageWriter.writeToStream(matrix, "PNG", outStream);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return outStream.toByteArray();
    }

    protected void OpenPdfReportFile() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File("reports/report.pdf"));
        } catch (IOException e) {
        }
    }
}
