package de.linogistix.los.inventory.query;


import javax.ejb.Remote;

import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.query.BusinessObjectQueryRemote;

@Remote
public interface LOSOrderReceipientsQueryRemote extends BusinessObjectQueryRemote<LOSOrderReceipients>{ 
	//public LOSResultList<BODTO<LOSOrderReceipients>> queryByDefault( String master, String child, QueryDetail detail ) throws BusinessObjectNotFoundException, BusinessObjectQueryException;

}
