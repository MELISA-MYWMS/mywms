package de.linogistix.los.inventory.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.mywms.model.BusinessException;
import org.mywms.model.VehicleData;
import org.mywms.service.ConstraintViolatedException;

import org.mywms.model.BasicEntity;

import de.linogistix.los.location.model.LOSStorageLocation;

import de.linogistix.los.inventory.model.LOSOrderReceipients;
import de.linogistix.los.inventory.model.OrderReceiptPosition;


@Entity
@Table(name = "los_fuel_order_log", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "transactionid"
    })
})
public class LOSFuelOrderLog extends BasicEntity {

    private static final long serialVersionUID = 1L;

    private String transactionId;
    private VehicleData vehicle;
    private LOSStorageLocation storLoc;
    private int stationPump;
    private LOSOrderReceipients receipient;
    private OrderReceiptPosition rcptPos;
    private String orderType;
    private BigDecimal tankRemaining;

    @Column(nullable = false)
    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    //TransactionID not unique?
    @Override
    public String toUniqueString() {
        if (getTransactionId() != null) {
            return getTransactionId();
        } else {
            return getId().toString();
        }
    }
    
    @PreUpdate
    @PrePersist
    public void sanityCheck() throws BusinessException, ConstraintViolatedException {

        if (getId() != null) {
            if (( getTransactionId() == null || getTransactionId().length() == 0 )) {
                setTransactionId(getId().toString());
            } else {
                //ok
            }
        } else {
            throw new RuntimeException("Id cannot be retrieved yet - hence TransactionId cannot be set");
        }

    }


    /**
     * Get storLoc.
     *
     * @return storLoc as LOSStorageLocation.
     */
    @ManyToOne(optional=false)
    public LOSStorageLocation getStorLoc() {
        return storLoc;
    }

    /**
     * Set storLoc.
     *
     * @param storLoc the value to set.
     */
    public void setStorLoc(LOSStorageLocation storLoc) {
        this.storLoc = storLoc;
    }

    /**
     * Get stationPump.
     *
     * @return stationPump as int.
     */
    public int getStationPump() {
        return stationPump;
    }

    /**
     * Set stationPump.
     *
     * @param stationPump the value to set.
     */
    public void setStationPump(int stationPump) {
        this.stationPump = stationPump;
    }

    /**
     * Get receipientId.
     *
     * @return receipientId as LOSOrderReceipients.
     */
    @ManyToOne(optional=false)
    public LOSOrderReceipients getReceipient() {
        return receipient;
    }
    
    /**
     * Set receipientId.
     *
     * @param receipientId the value to set.
     */
    public void setReceipient(LOSOrderReceipients receipient) {
        this.receipient = receipient;
    }

    /**
     * Get orderType.
     *
     * @return orderType as String.
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * Set orderType.
     *
     * @param orderType the value to set.
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * Get tankRemaining.
     *
     * @return tankRemaining as BigDecimal.
     */
    @Column(precision=18, scale=6)
    public BigDecimal getTankRemaining() {
        return tankRemaining;
    }

    /**
     * Set tankRemaining.
     *
     * @param tankRemaining the value to set.
     */
    public void setTankRemaining(BigDecimal tankRemaining) {
        this.tankRemaining = tankRemaining;
    }

    /**
     * Get rcptPos_Id.
     *
     * @return rcptPosId as OrderReceiptPosition.
     */
    @OneToOne(optional=true)
    public OrderReceiptPosition getRcptPos() {
        return rcptPos;
    }

    /**
     * Set rcptPos_Id.
     *
     * @param rcptPos_Id the value to set.
     */
    public void setRcptPos(OrderReceiptPosition rcptPos) {
        this.rcptPos = rcptPos;
    }
    
    /**
     * Get vehicle_Id.
     *
     * @return vehicle_Id as OrderReceiptPosition.
     */
    @ManyToOne(optional=true)
    public VehicleData getVehicle() {
        return vehicle;
    }
    
     
    /**
     * Set vehicle_Id.
     *
     * @param vehicle_Id the value to set.
     */
    public void setVehicle(VehicleData vehicle) {
        this.vehicle = vehicle;
    }
}
