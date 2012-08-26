package de.linogistix.inventory.browser.masternode;

import de.linogistix.common.bobrowser.bo.BOMasterNode;
import de.linogistix.common.bobrowser.bo.BO;

import de.linogistix.common.res.CommonBundleResolver;
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
            
	    //BOMasterNodeProperty<String> identityCard = new BOMasterNodeProperty<String>("identityCard", String.class, to.getIdentityCard(), CommonBundleResolver.class);
	    //sheet.put(identityCard);
            BOMasterNodeProperty<String> orderType= new BOMasterNodeProperty<String>("orderType", String.class, to.getOrderType(), CommonBundleResolver.class);
            sheet.put(orderType);
            BOMasterNodeProperty<String> storageLocation= new BOMasterNodeProperty<String>("storageLocation", String.class, to.getStorageLocation(), CommonBundleResolver.class);
            sheet.put(storageLocation);
            BOMasterNodeProperty<String> orderReceipient= new BOMasterNodeProperty<String>("orderReceipient", String.class, to.getOrderReceipient(), CommonBundleResolver.class);
            sheet.put(orderReceipient);
            BOMasterNodeProperty<BigDecimal> tankRemaining= new BOMasterNodeProperty<BigDecimal>("tankRemaining", BigDecimal.class, to.getTankRemaining(), CommonBundleResolver.class);
            sheet.put(tankRemaining);
        }
        return new PropertySet[] {sheet};
    }

    //-------------------------------------------------------------------------
    public static Property[] boMasterNodeProperties() {
	    //BOMasterNodeProperty<String> identityCard = new BOMasterNodeProperty<String>("identityCard", String.class, "", CommonBundleResolver.class);
        BOMasterNodeProperty<String> orderType = new BOMasterNodeProperty<String>("orderType", String.class, "", CommonBundleResolver.class);
        BOMasterNodeProperty<String> storageLocation = new BOMasterNodeProperty<String>("storageLocation", String.class, "", CommonBundleResolver.class);
        BOMasterNodeProperty<String> orderReceipient = new BOMasterNodeProperty<String>("orderReceipient", String.class, "", CommonBundleResolver.class);
        BOMasterNodeProperty<BigDecimal> tankRemaining = new BOMasterNodeProperty<BigDecimal>("tankRemaining", BigDecimal.class, BigDecimal.ZERO, CommonBundleResolver.class);
        BOMasterNodeProperty[] props = new BOMasterNodeProperty[] {
		//identityCard, 
		    orderType, storageLocation, orderReceipient, tankRemaining
        };
        return props;
    }
}
