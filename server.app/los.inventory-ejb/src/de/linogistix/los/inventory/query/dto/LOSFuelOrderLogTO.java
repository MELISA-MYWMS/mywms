package de.linogistix.los.inventory.query.dto;

import java.math.BigDecimal;

import org.mywms.model.VehicleData;

import de.linogistix.los.inventory.model.LOSFuelOrderLog;
import de.linogistix.los.query.BODTO;

import org.apache.log4j.Logger;
//import java.util.ResourceBundle;
public class LOSFuelOrderLogTO extends BODTO<LOSFuelOrderLog> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LOSFuelOrderLogTO.class);

    /*private String vehicle; //plateNumber
    private String storLoc; //name
    private int stationPump;
    private String receipient; //identityCard
    private long rcptPos; //id
    private String orderType;
    private BigDecimal tankRemaining;*/
	
	private String vehicleData;
	private String storageLocation;	
	private int stationPump;
	private String orderReceipient;
	private long orderRcptPos;
	private String orderType;
	private BigDecimal tankRemaining;

	private String plateNumber;
	private String fullName;
	private String firstName;
	private String rankName;
	private String lastName;
	private String articleRef;
	private String articleDescr;
		
	public LOSFuelOrderLogTO(LOSFuelOrderLog idat) {
        	super(idat.getId(), idat.getVersion(), idat.getTransactionId());
		this.storageLocation	= idat.getStorLocName();
		this.vehicleData 	= idat.getVehicleLabelID();
		this.stationPump	= idat.getStationPump();
		this.orderReceipient	= idat.getReceipientIDCard();
		this.orderType		= idat.getOrderType();
		this.tankRemaining	= idat.getTankRemaining();   
		this.orderRcptPos 	= idat.getRcptPosID();		
    		this.fullName 		= idat.getReceipientName();
		//this.fullName 		= idat.getReceipient().getRankAbbr();
		//this.fullName 		+= " ";
		//this.fullName 		+= idat.getReceipient().getFirstName();
		//this.fullName 		+= " ";
		//this.fullName 		+= idat.getReceipient().getLastName();         
		this.firstName		= idat.getReceipientName();
		this.rankName		= idat.getReceipientName();
		this.lastName		= idat.getReceipientName();
    		this.plateNumber 	= idat.getVehiclePlateNumber();
    		this.articleRef 	= idat.getRcptArticleRef();
    		this.articleDescr 	= idat.getRcptArticleDescr();    	
    }

    /*public long getStorLocID() {
    public String getStorLocName() {
    public int getStationPump() {
    public long getReceipientID() {
    public String getReceipientTokenID() {
    public String getReceipientName() {
    public String getReceipientIDCard() {
    public String getOrderType() {
    public BigDecimal getTankRemaining() {
    public long getRcptPosID() {
    public String getRcptArticleDescr() {
    public String getRcptArticleRef() {
    public BigDecimal getRcptPosQuantity() {
    public long getVehicleID() {
    public String getVehiclePlateNumber() {
    public String getVehicleLabelID() {*/

	public LOSFuelOrderLogTO(Long id, int version, String transactionId){
		super(id, version, transactionId);
	}
	
	public LOSFuelOrderLogTO(Long id, int version, String transactionId, 
			//String vehicleData, 
		String storageLocation, int stationPump, 
		String orderReceipient,
		//long orderRcptPos,
		String orderType, BigDecimal tankRemaining, 
		//String plateNumber,
		String firstName, String rankName, String lastName
		//, String articleRef, 	String articleDescr
		)
	{
		super(id, version, transactionId);
		this.storageLocation	= storageLocation;
		//this.vehicleData 	= vehicleData;
		this.stationPump	= stationPump;
		this.orderReceipient	= orderReceipient;
		//this.orderRcptPos 	= orderRcptPos;
		this.orderType		= orderType;
		this.tankRemaining	= tankRemaining;   	
		//this.plateNumber	= plateNumber;
		//this.fullName		= fullName;
		this.firstName		= firstName;
		this.rankName		= rankName;
		this.lastName		= lastName;
		//this.articleRef		= articleRef;
		//this.articleDescr	= articleDescr;
    		this.fullName 		= rankName + " " + firstName + " " + lastName;
	}


	
	/**
	 * Get vehicleData.
	 *
	 * @return vehicleData as String.
	 */
	public String getVehicleData()
	{
	    return vehicleData;
	}
	
	/**
	 * Set vehicleData.
	 *
	 * @param vehicleData the value to set.
	 */
	public void setVehicleData(String vehicleData)
	{
	    this.vehicleData = vehicleData;
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
	 * Get orderRcptPos.
	 *
	 * @return orderRcptPos as long.
	 */
	public long getOrderRcptPos()
	{
	    return orderRcptPos;
	}
	
	/**
	 * Set orderRcptPos.
	 *
	 * @param orderRcptPos the value to set.
	 */
	public void setOrderRcptPos(long orderRcptPos)
	{
	    this.orderRcptPos = orderRcptPos;
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
	public String getPlateNumber()
	{
	    return plateNumber;
	}
	
	/**
	 * Set plateNumber.
	 *
	 * @param plateNumber the value to set.
	 */
	public void setPlateNumber(String plateNumber)
	{
	    this.plateNumber = plateNumber;
	}
	
	/**
	 * Get fullName.
	 *
	 * @return fullName as String.
	 */
	public String getFullName()
	{
		fullName = rankName + " " + firstName + " " + lastName;
	    return fullName;
	}
	
	/**
	 * Set fullName.
	 *
	 * @param fullName the value to set.
	 */
	public void setFullName(String fullName)
	{
	    this.fullName = fullName;
	}
	
	/**
	 * Get firstName.
	 *
	 * @return firstName as String.
	 */
	public String getFirstName()
	{
	    return firstName;
	}
	
	/**
	 * Set firstName.
	 *
	 * @param firstName the value to set.
	 */
	public void setFirstName(String firstName)
	{
	    this.firstName = firstName;
	}
	
	/**
	 * Get rankName.
	 *
	 * @return rankName as String.
	 */
	public String getRankName()
	{
	    return rankName;
	}
	
	/**
	 * Set rankName.
	 *
	 * @param rankName the value to set.
	 */
	public void setRankName(String rankName)
	{
	    this.rankName = rankName;
	}
	
	/**
	 * Get lastName.
	 *
	 * @return lastName as String.
	 */
	public String getLastName()
	{
	    return lastName;
	}
	
	/**
	 * Set lastName.
	 *
	 * @param lastName the value to set.
	 */
	public void setLastName(String lastName)
	{
	    this.lastName = lastName;
	}
	
	/**
	 * Get articleRef.
	 *
	 * @return articleRef as String.
	 */
	public String getArticleRef()
	{
	    return articleRef;
	}
	
	/**
	 * Set articleRef.
	 *
	 * @param articleRef the value to set.
	 */
	public void setArticleRef(String articleRef)
	{
	    this.articleRef = articleRef;
	}
	
	/**
	 * Get articleDescr.
	 *
	 * @return articleDescr as String.
	 */
	public String getArticleDescr()
	{
	    return articleDescr;
	}
	
	/**
	 * Set articleDescr.
	 *
	 * @param articleDescr the value to set.
	 */
	public void setArticleDescr(String articleDescr)
	{
	    this.articleDescr = articleDescr;
	}
	//@Override
	//protected ResourceBundle getResourceBundle() {
	//ResourceBundle bundle;
	//Locale lo;
	//lo = getUIViewRoot().getLocale();
	//bundle = ResourceBundle.getBundle("de.linogistix.mobile.processes.fuel.FuelBundle", lo);
	//return bundle;
	//}
}
