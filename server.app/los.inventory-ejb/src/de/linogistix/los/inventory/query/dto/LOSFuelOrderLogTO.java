package de.linogistix.los.inventory.query.dto;

import java.math.BigDecimal;

import org.mywms.model.VehicleData;

import de.linogistix.los.inventory.model.LOSFuelOrderLog;
import de.linogistix.los.query.BODTO;

public class LOSFuelOrderLogTO extends BODTO<LOSFuelOrderLog> {

	private static final long serialVersionUID = 1L;
	
	//private OrderReceiptPosition rcptPosId;
	private String vehicleData;
	private String storageLocation;	
	private int stationPump;
	private String orderReceipient;
	private String orderType;
	private BigDecimal tankRemaining;
	private String fullName;
	private String plateNumber;
	private String articleRef;
	private String articleDescr;
		
	public LOSFuelOrderLogTO(LOSFuelOrderLog idat) {
        super(idat.getId(), idat.getVersion(), idat.getLabelId());
		this.storageLocation	= idat.getStorLoc().getName();
		this.vehicleData = idat.getVehicle().getLabelId();
		this.stationPump	= idat.getStationPump();
		this.orderReceipient	= idat.getReceipient().getIdentityCard();
		this.orderType	= idat.getOrderType();
		this.tankRemaining	= idat.getTankRemaining();   
				
    	this.fullName = idat.getReceipient().getRankAbbr();
    	this.fullName += " ";
    	this.fullName += idat.getReceipient().getFirstName();
    	this.fullName += " ";
    	this.fullName += idat.getReceipient().getLastName();         
    	
    	this.plateNumber = idat.getVehicle().getPlateNumber();
    	this.articleRef = idat.getRcptPos().getArticleRef();
    	this.articleDescr = idat.getRcptPos().getArticleDescr();    	
    }

	public LOSFuelOrderLogTO(Long id, int version, String name){
		super(id, version, name);
	}
	
	public LOSFuelOrderLogTO(Long id, int version, String name, String vehicleData, 
		String storageLocation, int stationPump, String orderReceipient, String orderType, BigDecimal tankRemaining,
		String fullName , String plateNumber , String articleRef, String articleDescr){
		super(id, version, name);
		this.storageLocation	= storageLocation;
		this.vehicleData = vehicleData;
		this.stationPump	= stationPump;
		this.orderReceipient	= orderReceipient;
		this.orderType	= orderType;
		this.tankRemaining	= tankRemaining;
		this.fullName = fullName;
		this.plateNumber = plateNumber;
    	this.articleRef = articleRef;
    	this.articleDescr = articleDescr;    	
	}

	
	/**
	 * Get storageLocation.
	 *
	 * @return storageLocation as String.
	 */
	public String getStorageLocation()
	{
	    return storageLocation;
	}
	
	/**
	 * Set storageLocation.
	 *
	 * @param storageLocation the value to set.
	 */
	public void setStorageLocation(String storageLocation)
	{
	    this.storageLocation = storageLocation;
	}
	
	/**
	 * Get stationPump.
	 *
	 * @return stationPump as int.
	 */
	public int getStationPump()
	{
	    return stationPump;
	}
	
	/**
	 * Set stationPump.
	 *
	 * @param stationPump the value to set.
	 */
	public void setStationPump(int stationPump)
	{
	    this.stationPump = stationPump;
	}
	
	/**
	 * Get orderReceipient.
	 *
	 * @return orderReceipient as String.
	 */
	public String getOrderReceipient()
	{
	    return orderReceipient;
	}
	
	/**
	 * Set orderReceipient.
	 *
	 * @param orderReceipient the value to set.
	 */
	public void setOrderReceipient(String orderReceipient)
	{
	    this.orderReceipient = orderReceipient;
	}
	
	/**
	 * Get orderType.
	 *
	 * @return orderType as String.
	 */
	public String getOrderType()
	{
	    return orderType;
	}
	
	/**
	 * Set orderType.
	 *
	 * @param orderType the value to set.
	 */
	public void setOrderType(String orderType)
	{
	    this.orderType = orderType;
	}
	
	/**
	 * Get tankRemaining.
	 *
	 * @return tankRemaining as BigDecimal.
	 */
	public BigDecimal getTankRemaining()
	{
	    return tankRemaining;
	}
	
	/**
	 * Set tankRemaining.
	 *
	 * @param tankRemaining the value to set.
	 */
	public void setTankRemaining(BigDecimal tankRemaining)
	{
	    this.tankRemaining = tankRemaining;
	}
	
	/**
	 * Get plateNumber.
	 *
	 * @return plateNumber as String.
	 */
    public String getPlateNumber() {
        return plateNumber;
    }
    
    /**
	 * Get fullName.
	 *
	 * @return fullName as String.
	 */
    public String getFullName() {
    	return fullName;
    }
    
    /**
	 * Get articleRef.
	 *
	 * @return articleRef as String.
	 */
    public String getArticleRef() {
        return articleRef;
    }
    
    /**
	 * Get articleDescr.
	 *
	 * @return articleDescr as String.
	 */
    public String getArticleDescr() {
        return articleDescr;
    }
}
