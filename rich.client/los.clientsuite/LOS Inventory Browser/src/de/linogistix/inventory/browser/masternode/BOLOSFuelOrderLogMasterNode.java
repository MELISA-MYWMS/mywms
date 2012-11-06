package de.linogistix.inventory.browser.masternode;

import de.linogistix.common.bobrowser.bo.BOMasterNode;
import de.linogistix.common.bobrowser.bo.BO;

//import de.linogistix.common.res.InventoryBundleResolver;
import de.linogistix.inventory.res.InventoryBundleResolver;
import de.linogistix.los.inventory.query.dto.LOSFuelOrderLogTO;
import de.linogistix.los.query.BODTO;
import java.beans.IntrospectionException;
import org.openide.nodes.Node.PropertySet;
import org.openide.nodes.Sheet;
import java.math.BigDecimal;

public class BOLOSFuelOrderLogMasterNode extends BOMasterNode {

    LOSFuelOrderLogTO to;

    /** Creates a new instance of BODeviceNode */
    public BOLOSFuelOrderLogMasterNode(BODTO d, BO bo) throws IntrospectionException {
        super(d, bo);
        to = (LOSFuelOrderLogTO) d;
    }

    @Override
    public PropertySet[] getPropertySets() {

        if (sheet == null) {
            sheet = new Sheet.Set();

            //BOMasterNodeProperty<String> identityCard = new BOMasterNodeProperty<String>("identityCard", String.class, to.getIdentityCard(), InventoryBundleResolver.class);
            //sheet.put(identityCard);

            //BOMasterNodeProperty<String> plateNumber= new BOMasterNodeProperty<String>("plateNumber", String.class, to.getPlateNumber(), InventoryBundleResolver.class);
            //sheet.put(plateNumber);
            BOMasterNodeProperty<String> fullName= new BOMasterNodeProperty<String>("fullName", String.class, to.getFullName(), InventoryBundleResolver.class);
            sheet.put(fullName);
            //BOMasterNodeProperty<String> articleRef= new BOMasterNodeProperty<String>("articleRef", String.class, to.getArticleRef(), InventoryBundleResolver.class);
            //sheet.put(articleRef);
            //BOMasterNodeProperty<String> articleDescr= new BOMasterNodeProperty<String>("articleDescr", String.class, to.getArticleDescr(), InventoryBundleResolver.class);
            //sheet.put(articleDescr);
            BOMasterNodeProperty<String> orderType= new BOMasterNodeProperty<String>("orderType", String.class, to.getOrderType(), InventoryBundleResolver.class);
            sheet.put(orderType);
            BOMasterNodeProperty<String> storageLocation= new BOMasterNodeProperty<String>("storageLocation", String.class, to.getStorageLocation(), InventoryBundleResolver.class);
            sheet.put(storageLocation);
            //BOMasterNodeProperty<String> orderReceipient= new BOMasterNodeProperty<String>("orderReceipient", String.class, to.getOrderReceipient(), InventoryBundleResolver.class);
            //sheet.put(orderReceipient);
            BOMasterNodeProperty<BigDecimal> tankRemaining= new BOMasterNodeProperty<BigDecimal>("tankRemaining", BigDecimal.class, to.getTankRemaining(), InventoryBundleResolver.class);
            sheet.put(tankRemaining);
        }
        return new PropertySet[] {sheet};
    }

    //-------------------------------------------------------------------------
    public static Property[] boMasterNodeProperties() {
        //BOMasterNodeProperty<String> identityCard = new BOMasterNodeProperty<String>("identityCard", String.class, "", InventoryBundleResolver.class);

        //BOMasterNodeProperty<String>  plateNumber = new BOMasterNodeProperty<String>("plateNumber", String.class, "", InventoryBundleResolver.class);
        BOMasterNodeProperty<String> fullName = new BOMasterNodeProperty<String>("fullName", String.class, "", InventoryBundleResolver.class);
        //BOMasterNodeProperty<String> articleRef = new BOMasterNodeProperty<String>("articleRef", String.class, "", InventoryBundleResolver.class);
        //BOMasterNodeProperty<String> articleDescr = new BOMasterNodeProperty<String>("articleDescr", String.class, "", InventoryBundleResolver.class);
        BOMasterNodeProperty<String> orderType = new BOMasterNodeProperty<String>("orderType", String.class, "", InventoryBundleResolver.class);
        BOMasterNodeProperty<String> storageLocation = new BOMasterNodeProperty<String>("storageLocation", String.class, "", InventoryBundleResolver.class);
        //BOMasterNodeProperty<String> orderReceipient = new BOMasterNodeProperty<String>("orderReceipient", String.class, "", InventoryBundleResolver.class);
        BOMasterNodeProperty<BigDecimal> tankRemaining = new BOMasterNodeProperty<BigDecimal>("tankRemaining", BigDecimal.class, BigDecimal.ZERO, InventoryBundleResolver.class);
        BOMasterNodeProperty[] props = new BOMasterNodeProperty[] {
            //identityCard,
            //plateNumber,
            fullName,
            //articleRef, articleDescr,
            orderType, storageLocation,
            //, orderReceipient,
            tankRemaining
        };
        return props;
    }
}
