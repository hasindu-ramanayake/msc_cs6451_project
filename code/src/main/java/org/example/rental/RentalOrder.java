package org.example.rental;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class RentalOrder implements IRentalOrder {
    private final String orderId;
    private final String customerId;
    private String vehicleId;
    private Date rentalDate;
    private float fee;
    private boolean isPaid;

    // this function use when reading from db. to populate data
    public RentalOrder(String orderId, String customerId, String vehicleId, Date rentalDate, float fee, boolean isPaid) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.fee = fee;
        this.isPaid = isPaid;
    }

    public RentalOrder(String customerId, String vehicleId, Date rentalDate, float fee, boolean isPaid) {
        super();
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.fee = fee;
        this.isPaid = isPaid;
        this.orderId = this.generateId();
    }

    @Override
    public String generateId(){
        Random rnd = new Random();
        return "O"+String.valueOf(rnd.nextInt());
    }

    @Override
    public String getOrderId(String orderId) {
        return "";
    }

    @Override
    public String getCustomerId() {
        return this.customerId;
    }

    @Override
    public LocalDateTime getRentalDate() {
        return null;
    }

    @Override
    public String getVehicleId() {
        return "";
    }

    @Override
    public double getFee() {
        return 0;
    }

    @Override
    public boolean getIsPaid() {
        return false;
    }

    @Override
    public String printRentalOrder() {
        return "";
    }

    @Override
    public void setCustomerId() {

    }

    @Override
    public void setRentalDate() {

    }

    @Override
    public void setVehicleId() {

    }

    @Override
    public void setIsPaid() {

    }

    @Override
    public void setFee() {

    }

}

