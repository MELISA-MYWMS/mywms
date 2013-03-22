package de.linogistix.inventory.browser.masternode;

import de.linogistix.common.bobrowser.bo.BOMasterNode;
import de.linogistix.common.bobrowser.bo.BO;

//import de.linogistix.common.res.InventoryBundleResolver;
import de.linogistix.inventory.res.InventoryBundleResolver;
import de.linogistix.los.inventory.query.dto.MovementOrderLogTO;
import de.linogistix.los.query.BODTO;
import java.beans.IntrospectionException;
import org.openide.nodes.Node.PropertySet;
import org.openide.nodes.Sheet;
import java.math.BigDecimal;
import java.util.Date;

public class BOMovementOrderLogMasterNode extends BOMasterNode {

    MovementOrderLogTO to;

    /** Creates a new instance of BODeviceNode */
    public BOMovementOrderLogMasterNode(BODTO d, BO bo) throws IntrospectionException {
        super(d, bo);
        to = (MovementOrderLogTO) d;
    }

    @Override
    public PropertySet[] getPropertySets() {

        if (sheet == null) {
            sheet = new Sheet.Set();
                
	    //BOMasterNodeProperty<String> identityCard = new BOMasterNodeProperty<String>("identityCard", String.class, to.getIdentityCard(), InventoryBundleResolver.class);
	    //sheet.put(identityCard);

                BOMasterNodeProperty<String> organization= new BOMasterNodeProperty<String>("organization", String.class, to.getOrganization(), InventoryBundleResolver.class);
                sheet.put(organization);
                BOMasterNodeProperty<String>formation= new BOMasterNodeProperty<String>("formation", String.class, to.getFormation(), InventoryBundleResolver.class);
		sheet.put(formation);
                BOMasterNodeProperty<String>militaryUnit= new BOMasterNodeProperty<String>("militaryUnit", String.class, to.getMilitaryUnit(), InventoryBundleResolver.class);
		sheet.put(militaryUnit);
                BOMasterNodeProperty<Long>sequenceNumber= new BOMasterNodeProperty<Long>("sequenceNumber", Long.class, to.getSequenceNumber(), InventoryBundleResolver.class);
		sheet.put(sequenceNumber);
                BOMasterNodeProperty<String> plateNumber= new BOMasterNodeProperty<String>("plateNumber", String.class, to.getPlateNo(), InventoryBundleResolver.class);
		sheet.put(plateNumber);
                BOMasterNodeProperty<String> vehicleType= new BOMasterNodeProperty<String>("vehicleType", String.class, to.getVehicleType(), InventoryBundleResolver.class);
		sheet.put(vehicleType);
                BOMasterNodeProperty<Date> movementDate= new BOMasterNodeProperty<Date>("movementDate", Date.class, to.getMovementDate(), InventoryBundleResolver.class);
		sheet.put(movementDate);
                BOMasterNodeProperty<String> orderNo= new BOMasterNodeProperty<String>("orderNo", String.class, to.getOrderNo(), InventoryBundleResolver.class);
		sheet.put(orderNo);
		BOMasterNodeProperty<String>  movementPurpose= new BOMasterNodeProperty<String>("movementPurpose", String.class, to.getMovementPurpose(), InventoryBundleResolver.class);
		sheet.put(movementPurpose);
                BOMasterNodeProperty<String> movementRoute= new BOMasterNodeProperty<String>("movementRoute", String.class, to.getMovementRoute(), InventoryBundleResolver.class);
		sheet.put(movementRoute);
		BOMasterNodeProperty<String> movementLoad= new BOMasterNodeProperty<String>("movementLoad", String.class, to.getMovementLoad(), InventoryBundleResolver.class);
		sheet.put(movementLoad);
                BOMasterNodeProperty<String> driverName= new BOMasterNodeProperty<String>("driverName", String.class, to.getDriverName(), InventoryBundleResolver.class);
                sheet.put(driverName);
                BOMasterNodeProperty<String> passenger1Name= new BOMasterNodeProperty<String>("passenger1Name", String.class, to.getPassenger1Name(), InventoryBundleResolver.class);
                sheet.put(passenger1Name);
                BOMasterNodeProperty<String> passenger2Name= new BOMasterNodeProperty<String>("passenger2Name", String.class, to.getPassenger2Name(), InventoryBundleResolver.class);
                sheet.put(passenger2Name);
                BOMasterNodeProperty<String> passenger3Name= new BOMasterNodeProperty<String>("passenger3Name", String.class, to.getPassenger3Name(), InventoryBundleResolver.class);
                sheet.put(passenger3Name);
                BOMasterNodeProperty<String> passenger4Name= new BOMasterNodeProperty<String>("passenger4Name", String.class, to.getPassenger4Name(), InventoryBundleResolver.class);
                sheet.put(passenger4Name);
        }
        return new PropertySet[] {sheet};
    }

    //-------------------------------------------------------------------------
    public static Property[] boMasterNodeProperties() {


                BOMasterNodeProperty<String> organization= new BOMasterNodeProperty<String>("organization", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String>formation= new BOMasterNodeProperty<String>("formation", String.class,"", InventoryBundleResolver.class);
                BOMasterNodeProperty<String>militaryUnit= new BOMasterNodeProperty<String>("militaryUnit", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<Long>sequenceNumber= new BOMasterNodeProperty<Long>("sequenceNumber", Long.class, 0L, InventoryBundleResolver.class);
                BOMasterNodeProperty<String> plateNumber= new BOMasterNodeProperty<String>("plateNumber", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> vehicleType= new BOMasterNodeProperty<String>("vehicleType", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<Date> movementDate= new BOMasterNodeProperty<Date>("movementDate", Date.class, new Date(), InventoryBundleResolver.class);
                BOMasterNodeProperty<String> orderNo= new BOMasterNodeProperty<String>("orderNo", String.class, "", InventoryBundleResolver.class);
		BOMasterNodeProperty<String>  movementPurpose= new BOMasterNodeProperty<String>("movementPurpose", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> movementRoute= new BOMasterNodeProperty<String>("movementRoute", String.class,"", InventoryBundleResolver.class);
		BOMasterNodeProperty<String> movementLoad= new BOMasterNodeProperty<String>("movementLoad", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> driverName= new BOMasterNodeProperty<String>("driverName", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> passenger1Name= new BOMasterNodeProperty<String>("passenger1Name", String.class,"", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> passenger2Name= new BOMasterNodeProperty<String>("passenger2Name", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> passenger3Name= new BOMasterNodeProperty<String>("passenger3Name", String.class, "", InventoryBundleResolver.class);
                BOMasterNodeProperty<String> passenger4Name= new BOMasterNodeProperty<String>("passenger4Name", String.class, "", InventoryBundleResolver.class);

        BOMasterNodeProperty[] props = new BOMasterNodeProperty[] {
		//identityCard,
                organization, formation, militaryUnit,sequenceNumber, plateNumber, vehicleType, movementDate, orderNo, movementPurpose, movementRoute, movementLoad, driverName, passenger1Name, passenger2Name, passenger3Name, passenger4Name
        };
        return props;
    }
}
