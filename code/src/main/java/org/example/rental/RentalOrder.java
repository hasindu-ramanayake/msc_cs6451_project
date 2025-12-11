package org.example.rental;

import org.example.core.RandomKeyGenerator;

import java.util.Date;


public class RentalOrder implements IRentalOrder {
    protected final String orderId;
    private String customerId;
    private String vehicleId;
    private Date rentalDate;
    private float fee;
    private float loyaltyPoints;
    private boolean isPaid;

    // this function use when reading from db. to populate data
    public RentalOrder(String orderId, String customerId, String vehicleId, Date rentalDate, float fee, float loyaltyPoints, boolean isPaid) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.fee = fee;
        this.loyaltyPoints= loyaltyPoints;
        this.isPaid = isPaid;
    }

    public RentalOrder(String customerId, String vehicleId, Date rentalDate ) {
        super();
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.isPaid = false;
        this.fee = 100;
        this.orderId = this.generateId();
    }

    @Override
    public String generateId(){
        return RandomKeyGenerator.generateRandomKey();
    }

    @Override
    public String getOrderId() {
        return this.orderId;
    }

    @Override
    public String getCustomerId() {
        return this.customerId;
    }

    @Override
    public Date getRentalDate() {
        return rentalDate;
    }

    @Override
    public String getVehicleId() {
        return vehicleId;
    }

    @Override
    public float getFee() {
        return fee;
    }
    @Override
    public float getLoyaltyPoints(){ return loyaltyPoints; }

    @Override
    public boolean getIsPaid() {
        return false;
    }

    @Override
    public String printRentalOrder() {
        return "Order ID: "+orderId +
                "\nPaid By Customer: "+customerId+
                "\nPayment Successful: "+isPaid+
                "\nFee: "+getFee();
    }

    @Override
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    @Override
    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;

    }

    @Override
    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;

    }

    @Override
    public void setFee(float fee) {
        this.fee = fee;

    }
    @Override
    public void setLoyaltyPoints(float loyaltyPoints){
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "RentalOrder{" +
                "orderId='" + orderId +
                "\ncustomerId='" + customerId +
                "\nvehicleId='" + vehicleId +
                "\nrentalDate=" + rentalDate +
                "\nfee=" + fee +
                "\nisPaid=" + isPaid +
                '}';
    }
}

