package de.linogistix.los.inventory.service;

import java.util.Date;

import javax.ejb.Remote;

import org.mywms.model.ItemData;
import de.linogistix.los.inventory.model.MovementOrderLog;
import org.mywms.service.BasicService;

/*
 * Defines interface for MovementOrder
 * 
 */

@Remote
public interface MovementOrderLogService extends BasicService<MovementOrderLog> {

	public MovementOrderLog create(String organization,
			String formation, String militaryUnit, long sequenceNumber,Date currDate, String plateNo,
			String vehicleType, Date movementDate, String orderNo,
			String movementPurpose, String movementRoute, String movementLoad,
			String driverName, String passenger1Name, String passenger2Name,
			String passenger3Name, String passenger4Name);
}
