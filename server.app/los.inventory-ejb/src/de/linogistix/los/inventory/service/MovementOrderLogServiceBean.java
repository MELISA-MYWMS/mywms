package de.linogistix.los.inventory.service;

import javax.ejb.Stateless;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.mywms.service.BasicServiceBean;

import de.linogistix.los.inventory.model.MovementOrderLog;

@Stateless
public class MovementOrderLogServiceBean extends BasicServiceBean<MovementOrderLog>
		implements MovementOrderLogService {
	private static final Logger log = Logger
			.getLogger(MovementOrderLogServiceBean.class);

	
	public MovementOrderLog create(String organization,
			String formation, String militaryUnit, long sequenceNumber,Date currDate
			, String plateNo,
			String vehicleType, Date movementDate, String orderNo,
			String movementPurpose, String movementRoute, String movementLoad,
			String driverName, String passenger1Name, String passenger2Name,
			String passenger3Name, String passenger4Name) {
		
		MovementOrderLog myNewMovementOrder;
		
		
		if (organization == null || formation == null || militaryUnit == null
				|| plateNo == null || movementDate == null
				|| orderNo == null || movementRoute == null
				|| movementPurpose == null || driverName == null) {
			throw new NullPointerException(
					"Creating new movement order failed due to missing parameter(s)");
		} else {

			myNewMovementOrder = new MovementOrderLog();
			myNewMovementOrder.setCurrDate(currDate);
			myNewMovementOrder.setOrganization(organization);
			myNewMovementOrder.setFormation(formation);
			myNewMovementOrder.setMilitaryUnit(militaryUnit);
			myNewMovementOrder.setPlateNo(plateNo);
			if (vehicleType != null)
				myNewMovementOrder.setVehicleType(vehicleType);
			myNewMovementOrder.setMovementDate(movementDate);
			myNewMovementOrder.setOrderNo(orderNo);
			myNewMovementOrder.setMovementPurpose(movementPurpose);
			myNewMovementOrder.setMovementRoute(movementRoute);
			if (movementLoad != null)
				myNewMovementOrder.setMovementLoad(movementLoad);
			myNewMovementOrder.setDriverName(driverName);
			myNewMovementOrder.setPassenger1Name(passenger1Name);
			myNewMovementOrder.setPassenger2Name(passenger2Name);
			myNewMovementOrder.setPassenger3Name(passenger3Name);
			myNewMovementOrder.setPassenger4Name(passenger4Name);	
		}
		
			manager.persist(myNewMovementOrder);
			manager.flush();
			return myNewMovementOrder;
	}
	
}
