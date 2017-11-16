/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deliverymodule;

/**
 *
 * @author Administrator
 */
public class DeliveryMan {
    private int deliveryId;
    private String deliveryName;
    private String password;

    public DeliveryMan(int deliveryId, String deliveryName, String password) {
        this.deliveryId = deliveryId;
        this.deliveryName = deliveryName;
        this.password = password;
    }

    public DeliveryMan() {
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public String getPassword() {
        return password;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
