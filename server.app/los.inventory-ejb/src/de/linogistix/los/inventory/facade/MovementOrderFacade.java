/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.los.inventory.facade;

import java.util.Date;

import javax.ejb.Remote;

import org.mywms.facade.FacadeException;
import org.mywms.model.VehicleData;
import org.mywms.model.Zone;

import de.linogistix.los.inventory.model.MovementOrderLog;
import de.linogistix.los.inventory.model.LOSFormationType;
import de.linogistix.los.inventory.model.LOSOrderReceipients;

@Remote
public interface MovementOrderFacade {
	public MovementOrderLog createMovementOrder(String organization,
			String formation, Zone militaryUnit, Date currDate,
			VehicleData vehicle, Date movementDate, String orderNo,
			String movementPurpose, String movementRoute, String movementLoad,
			LOSOrderReceipients driver, String passenger1Name,
			String passenger2Name, String passenger3Name, String passenger4Name)
			throws FacadeException;

}
