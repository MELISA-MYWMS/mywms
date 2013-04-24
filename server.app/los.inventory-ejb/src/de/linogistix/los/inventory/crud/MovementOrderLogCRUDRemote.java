package de.linogistix.los.inventory.crud;

import javax.ejb.Remote;

import de.linogistix.los.crud.BusinessObjectCRUDRemote;
import de.linogistix.los.inventory.model.MovementOrderLog;

@Remote
public interface MovementOrderLogCRUDRemote extends
		BusinessObjectCRUDRemote<MovementOrderLog> {

}
