package de.linogistix.los.inventory.service;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.mywms.service.BasicServiceBean;

import java.math.BigDecimal;
import org.mywms.service.BasicService;
import org.mywms.model.VehicleData;
import de.linogistix.los.location.model.LOSStorageLocation;
import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.inventory.model.OrderReceiptPosition;

import de.linogistix.los.inventory.model.LOSFuelOrderLog;
@Stateless
public class LOSFuelOrderLogServiceBean extends BasicServiceBean<LOSFuelOrderLog> implements LOSFuelOrderLogService{

	Logger log = Logger.getLogger(LOSFuelOrderLogServiceBean.class);

	public LOSFuelOrderLog create(VehicleData vehicle, LOSStorageLocation storLoc, int stationPump, LOSOrderReceipients receipient, 
				OrderReceiptPosition rcptPos, String orderType, BigDecimal tankRemaining){

		//log.error("MELISA fuel log "+vehicle.getLabelId());
		LOSFuelOrderLog fuelLog = new LOSFuelOrderLog(); 

		fuelLog.setVehicle(vehicle);
		fuelLog.setStorLoc(storLoc);
		fuelLog.setStationPump(stationPump);
		fuelLog.setReceipient(receipient);
		fuelLog.setOrderType(orderType);
		fuelLog.setTankRemaining(tankRemaining);
		fuelLog.setRcptPos(rcptPos);

		manager.persist(fuelLog);
		manager.flush();
		return fuelLog;
	}
}
