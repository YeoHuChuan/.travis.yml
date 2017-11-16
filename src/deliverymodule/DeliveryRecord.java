/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymodule;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DeliveryRecord {
    
    private DeliveryMan deliveryMan;
    private Date clockIn;
    private Date clockOut;
    private String orInOut = "In";

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public Date getClockIn() {
        return clockIn;
    }

    public Date getClockOut() {
        return clockOut;
    }

    public DeliveryRecord() {
        
    }

    public DeliveryRecord(DeliveryMan deliveryMan, Date clockIn) {
        this.deliveryMan = deliveryMan;
        this.clockIn = clockIn;
    }
    
    public DeliveryRecord(DeliveryMan deliveryMan, Date clockIn, Date clockOut) {
        this.deliveryMan = deliveryMan;
        this.clockIn = clockIn;
        this.clockOut = clockOut;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public void setClockIn(Date clockIn) {
        this.clockIn = clockIn;
    }

    public void setClockOut(Date clockOut) {
        this.clockOut = clockOut;
    }

    public void setOrInOut(String orInOut) {
        this.orInOut = orInOut;
    }

    public String getOrInOut() {
        return orInOut;
    }

    @Override
    public String toString() {
        return "DeliveryRecord{" + "deliveryMan=" + deliveryMan + ", clockIn=" + clockIn + ", clockOut=" + clockOut + ", orInOut=" + orInOut + '}';
    }

   
    
}
