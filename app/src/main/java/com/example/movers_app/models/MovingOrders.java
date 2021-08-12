
package com.example.movers_app.models;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class MovingOrders {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("inventory")
    @Expose
    private String inventory;
    @SerializedName("current_location")
    @Expose
    private String currentLocation;
    @SerializedName("new_location")
    @Expose
    private String newLocation;
    @SerializedName("moving_company")
    @Expose
    private String movingCompany;
    @SerializedName("total_price")
    @Expose
    private Integer totalPrice;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("pickup_time")
    @Expose
    private String pickupTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MovingOrders() {
    }

    /**
     * 
     * @param pickupTime
     * @param movingCompany
     * @param totalPrice
     * @param orderStatus
     * @param userEmail

     * @param userName
     * @param inventory
     * @param newLocation
     * @param currentLocation
     */
    public MovingOrders( String userName, String userEmail, String inventory, String currentLocation, String newLocation, String movingCompany, Integer totalPrice, String orderStatus, String pickupTime) {
        super();

        this.userName = userName;
        this.userEmail = userEmail;
        this.inventory = inventory;
        this.currentLocation = currentLocation;
        this.newLocation = newLocation;
        this.movingCompany = movingCompany;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.pickupTime = pickupTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getNewLocation() {
        return newLocation;
    }

    public void setNewLocation(String newLocation) {
        this.newLocation = newLocation;
    }

    public String getMovingCompany() {
        return movingCompany;
    }

    public void setMovingCompany(String movingCompany) {
        this.movingCompany = movingCompany;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

}
