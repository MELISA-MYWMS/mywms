package de.linogistix.los.inventory.query.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

import de.linogistix.los.inventory.model.LOSFormationType;
import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.inventory.model.MovementOrderLog;
import de.linogistix.los.query.BODTO;

import org.apache.log4j.Logger;
import org.mywms.model.Zone;

public class MovementOrderLogTO extends BODTO<MovementOrderLog> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(MovementOrderLogTO.class);

	private String organization;
	private LOSFormationType formation;
	private Zone militaryUnit;
	//private long sequenceNumber;
	private Date currDate;
	private String plateNo;
	private String vehicleType;
	private Date movementDate;
	private String orderNo;
	private String movementPurpose;
	private String movementRoute;
	private String movementLoad;
	private LOSOrderReceipients driver;
	private String passenger1Name;
	private String passenger2Name;
	private String passenger3Name;
	private String passenger4Name;

	public MovementOrderLogTO(MovementOrderLog idat) {
		super(idat.getId(), idat.getVersion(), idat.getTransactionId());
		this.organization = idat.getOrganization();
		this.formation = idat.getFormation();
		this.militaryUnit = idat.getMilitaryUnit();
		//this.sequenceNumber = idat.getSequenceNumber();
		this.currDate = idat.getCreated();
		this.plateNo = idat.getPlateNo();
		this.vehicleType = idat.getVehicleType();
		this.movementDate = idat.getMovementDate();
		this.orderNo = idat.getOrderNo();
		this.movementPurpose = idat.getMovementPurpose();
		this.movementRoute = idat.getMovementRoute();
		this.movementLoad = idat.getMovementLoad();
		this.driver = idat.getDriver();
		this.passenger1Name = idat.getPassenger1Name();
		this.passenger2Name = idat.getPassenger2Name();
		this.passenger3Name = idat.getPassenger3Name();
		this.passenger4Name = idat.getPassenger4Name();
	}

	public MovementOrderLogTO(Long id, int version, String transactionId) {
		super(id, version, transactionId);
	}

	public MovementOrderLogTO(Long id, int version, String transactionId, String organization, LOSFormationType formation,
			Zone militaryUnit,Date currDate, String plateNo, String vehicleType,
			Date movementDate,
			String orderNo, String movementPurpose,
			String movementRoute, String movementLoad, LOSOrderReceipients driver,
			String passenger1Name, String passenger2Name,
			String passenger3Name, String passenger4Name) {
		super(id, version, transactionId);
		this.organization = organization;
		this.formation = formation;
		this.militaryUnit = militaryUnit;
		//this.sequenceNumber = sequenceNumber;
		this.currDate = currDate;
		this.plateNo = plateNo;
		this.vehicleType = vehicleType;
		this.movementDate = movementDate;
		this.orderNo = orderNo;
		this.movementPurpose = movementPurpose;
		this.movementRoute = movementRoute;
		this.movementLoad = movementLoad;
		this.driver = driver;
		this.passenger1Name = passenger1Name;
		this.passenger2Name = passenger2Name;
		this.passenger3Name = passenger3Name;
		this.passenger4Name = passenger4Name;
	}


	public String getOrganization() {
		return this.organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public LOSFormationType getFormation() {
		return this.formation;
	}

	public void setFormation(LOSFormationType formation) {
		this.formation = formation;
	}

	public Zone getMilitaryUnit() {
		return this.militaryUnit;
	}

	public void setMilitaryUnit(Zone militaryUnit) {
		this.militaryUnit = militaryUnit;
	}

	/*public Long getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(Long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
*/
	public Date getCurrDate() {
		return this.currDate;
	}

	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}

	public String getPlateNo() {
		return this.plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getMovementDate() {
		return this.movementDate;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

	public String getMovementPurpose() {
		return this.movementPurpose;
	}

	public void setMovementPurpose(String movementPurpose) {
		this.movementPurpose = movementPurpose;
	}

	public String getMovementRoute() {
		return this.movementRoute;
	}

	public void setMovementRoute(String movementRoute) {
		this.movementRoute = movementRoute;
	}

	public String getMovementLoad() {
		return this.movementLoad;
	}

	public void setMovementLoad(String movementLoad) {
		this.movementLoad = movementLoad;
	}

	public LOSOrderReceipients getDriver() {
		return this.driver;
	}

	public void setDriver(LOSOrderReceipients driver) {
		this.driver= driver;
	}

	public String getPassenger1Name() {
		return this.passenger1Name;
	}

	public void setPassenger1Name(String passenger1Name) {
		this.passenger1Name = passenger1Name;
	}

	public String getPassenger2Name() {
		return this.passenger2Name;
	}

	public void setPassenger2Name(String passenger2Name) {
		this.passenger2Name = passenger2Name;
	}

	public String getPassenger3Name() {
		return this.passenger3Name;
	}

	public void setPassenger3Name(String passenger3Name) {
		this.passenger3Name = passenger3Name;
	}

	public String getPassenger4Name() {
		return this.passenger4Name;
	}

	public void setPassenger4Name(String passenger4Name) {
		this.passenger4Name = passenger4Name;
	}

}
