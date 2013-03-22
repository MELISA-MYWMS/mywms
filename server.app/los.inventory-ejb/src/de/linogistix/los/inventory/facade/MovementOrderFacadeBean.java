/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.los.inventory.facade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.mywms.facade.BasicFacadeBean;
import org.mywms.facade.FacadeException;

import de.linogistix.los.inventory.service.MovementOrderLogService;
import de.linogistix.los.inventory.businessservice.LOSGoodsReceiptComponent;
import de.linogistix.los.inventory.exception.InventoryException;
import de.linogistix.los.inventory.exception.InventoryExceptionKey;
import de.linogistix.los.inventory.model.LOSAdvice;
import de.linogistix.los.inventory.model.LOSAdviceState;
import de.linogistix.los.inventory.model.LOSGoodsReceipt;
import de.linogistix.los.inventory.model.LOSGoodsReceiptState;
import de.linogistix.los.inventory.model.MovementOrderLog;
import de.linogistix.los.inventory.service.LOSGoodsReceiptService;
import de.linogistix.los.query.BODTO;

@Stateless
public class MovementOrderFacadeBean extends BasicFacadeBean implements
		MovementOrderFacade {
	Logger log = Logger.getLogger(MovementOrderFacadeBean.class);

	@EJB
	private MovementOrderLogService movementOrderService;
	/*
	 * @EJB private LOSGoodsReceiptComponent grComponent;
	 * 
	 * @EJB private LOSGoodsReceiptService grService;
	 */

	@PersistenceContext(unitName = "myWMS")
	protected EntityManager manager;


	public boolean createMovementOrder(String organization, String formation,
			String militaryUnit,Long sequenceNumber,Date currDate, String plateNo, String vehicleType,
			Date movementDate,
			String orderNo, String movementPurpose,
			String movementRoute, String movementLoad, String driverName,
			String passenger1Name, String passenger2Name,
			String passenger3Name, String passenger4Name) throws FacadeException {
		movementOrderService.create(organization, formation, militaryUnit, sequenceNumber, currDate, plateNo, vehicleType, movementDate, orderNo, movementPurpose, movementRoute, movementLoad, driverName, passenger1Name, passenger2Name, passenger3Name, passenger4Name);
			
		return true;
	}

}
