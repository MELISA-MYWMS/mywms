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
import de.linogistix.common.gui.component.windows.ProgressDialog;
import de.linogistix.wmsprocesses.res.WMSProcessesBundleResolver;
import java.awt.Desktop;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
import java.security.MessageDigest;
import java.util.Arrays;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 *
 * @author Parhs Rozakhs
 */
public class PdfReport extends Thread {

    private final static Logger log = Logger.getLogger(PdfReport.class.getName());
    private final static String hashSaltCode = "1369876532158832168";
    protected String transactionId;
    protected String organization;
    protected String formation;
    protected String militaryUnit;
    protected Date currDate;
    protected String plateNo;
    protected String vehicleType;
    protected String vehicleID;
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
    private ProgressDialog progDialog;
    private List<String> pdMessages;
    final ProgressHandle progrHandle = ProgressHandleFactory.createHandle("");

    public PdfReport(MovementOrderLog myOrder) {
        transactionId = myOrder.getTransactionId();
        organization = myOrder.getOrganization();
        formation = myOrder.getFormation();
        militaryUnit = myOrder.getMilitaryUnit().getName();
        currDate = myOrder.getCurrDate();
        plateNo = myOrder.getVehicle().getPlateNumber();
        vehicleType = myOrder.getVehicle().getModelName();
        vehicleID = myOrder.getVehicle().getId().toString();
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
        pdMessages = Arrays.asList(
                NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.creatingMessage"),
                NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.exportingMessage"),
                NbBundle.getMessage(WMSProcessesBundleResolver.class, "MovementOrderCenterPanel.openingMessage"));
        progDialog = ProgressDialog.getInstance();
    }
    

    @Override
    public void run() {
        progrHandle.start(100);
        progDialog.DialogShow();
        createMovementOrderReport();        
    }

    public void createMovementOrderReport() {
        try {
            // load report location
            // fill report
            progrHandle.progress(10);
            progrHandle.setDisplayName(pdMessages.get(0));
            progDialog.setProgress(10, pdMessages.get(0));
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

            ByteArrayInputStream QRStream = new ByteArrayInputStream(Str2QR(hash(transactionId + vehicleID + driverID)));
            map.put("IDImage", QRStream);
            ByteArrayInputStream BrcdStream = new ByteArrayInputStream(Str2Brcd(vehicleID));
            map.put("VehicleID", BrcdStream);
            ByteArrayInputStream BrcdStream2 = new ByteArrayInputStream(Str2Brcd(driverID));
            map.put("DriverID", BrcdStream2);
            maps.add(map);
            progrHandle.progress(20);
            progDialog.setProgress(20);
            JRMapCollectionDataSource dataSource = new JRMapCollectionDataSource(maps);
            progrHandle.progress(30);
            progDialog.setProgress(30);
            // compile report
            JasperReport jasperReport =
                    JasperCompileManager.compileReport("reports/MovementOrder.jrxml");
            progrHandle.progress(50);
            progrHandle.setDisplayName(pdMessages.get(1));
            progDialog.setProgress(50, pdMessages.get(1));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<String, Object>(), dataSource);

            // view report to UI
            //JasperViewer.viewReport(jasperPrint, false);
            progrHandle.progress(80);
            progrHandle.setDisplayName(pdMessages.get(2));
            progDialog.setProgress(80, pdMessages.get(2));
            JasperExportManager.exportReportToPdfFile(jasperPrint, "reports/report.pdf");
        } catch (JRException ex) {
            progrHandle.suspend("PDF Creation error");
            Logger.getLogger(PdfReport.class.getName()).log(Level.SEVERE, null, ex);
        }

        progrHandle.progress(90);
        progDialog.setProgress(90);
        OpenPdfReportFile();
        progDialog.setProgress(100);
        progrHandle.finish();
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

    private String hash(String text) {
        text += hashSaltCode;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            Exceptions.printStackTrace(ex);
        }
        messageDigest.update(text.getBytes());
        String encryptedString = new String(messageDigest.digest());
        return encryptedString;
    }

    protected void OpenPdfReportFile() {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(new File("reports/report.pdf"));
        } catch (IOException e) {
        }
    }
}
