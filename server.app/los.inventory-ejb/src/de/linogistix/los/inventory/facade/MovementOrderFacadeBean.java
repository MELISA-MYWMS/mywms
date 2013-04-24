/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.los.inventory.facade;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.mywms.facade.BasicFacadeBean;
import org.mywms.facade.FacadeException;
import org.mywms.model.VehicleData;
import org.mywms.model.Zone;

import de.linogistix.los.inventory.service.MovementOrderLogService;
import de.linogistix.los.inventory.model.LOSFormationType;
import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.inventory.model.MovementOrderLog;

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

	@Override
	public MovementOrderLog createMovementOrder(String organization,
			LOSFormationType formation, Zone militaryUnit, Date currDate,
			VehicleData vehicle, Date movementDate, String orderNo,
			String movementPurpose, String movementRoute, String movementLoad,
			LOSOrderReceipients driver, String passenger1Name,
			String passenger2Name, String passenger3Name, String passenger4Name)
			throws FacadeException {
		return movementOrderService.create(organization, formation,
				militaryUnit, currDate, vehicle, movementDate, orderNo,
				movementPurpose, movementRoute, movementLoad, driver,
				passenger1Name, passenger2Name, passenger3Name, passenger4Name);

	}

}
