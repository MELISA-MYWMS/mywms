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
import org.mywms.model.Zone;

import de.linogistix.los.inventory.exception.InventoryException;
import de.linogistix.los.inventory.model.LOSAdvice;
import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.query.BODTO;

@Remote
public interface MovementOrderFacade {
	public boolean createMovementOrder(String organization, String formation,
			Zone militaryUnit,Long sequenceNumber,Date currDate, String plateNo, String vehicleType,
	Date movementDate,
	String orderNo, String movementPurpose,
	String movementRoute, String movementLoad, LOSOrderReceipients driver,
	String passenger1Name, String passenger2Name,
	String passenger3Name, String passenger4Name) throws FacadeException;
    
}
