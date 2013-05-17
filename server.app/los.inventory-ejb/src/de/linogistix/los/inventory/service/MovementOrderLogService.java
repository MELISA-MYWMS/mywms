package de.linogistix.los.inventory.service;

import java.util.Date;

import javax.ejb.Remote;

import org.mywms.model.VehicleData;
import org.mywms.model.Zone;

import de.linogistix.los.inventory.model.LOSFormationType;
import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.inventory.model.MovementOrderLog;
import org.mywms.service.BasicService;

/*
 * Defines interface for MovementOrder
 * 
 */

@Remote
public interface MovementOrderLogService extends BasicService<MovementOrderLog> {

	public MovementOrderLog create(String organization,
			String formation, Zone militaryUnit, Date currDate,
			VehicleData vehicle, Date movementDate, String orderNo,
			String movementPurpose, String movementRoute, String movementLoad,
			LOSOrderReceipients driver, String passenger1Name,
			String passenger2Name, String passenger3Name, String passenger4Name);
}
