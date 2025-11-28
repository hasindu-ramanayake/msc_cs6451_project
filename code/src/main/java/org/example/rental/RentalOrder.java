package org.example.rental;

import java.util.Date;
import java.util.Random;

public class RentalOrder implements IRentalOrder {
    private final String orderId;
    private String customerId;
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

    public RentalOrder(String customerId, String vehicleId, Date rentalDate ) {
        super();
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.isPaid = false;
        this.orderId = this.generateId();
    }

    @Override
    public String generateId(){
        Random rnd = new Random();
        return "O"+String.valueOf(rnd.nextInt());
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
    public double getFee() {
        return fee;
    }

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
    public String toString() {
        return "RentalOrder{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", rentalDate=" + rentalDate +
                ", fee=" + fee +
                ", isPaid=" + isPaid +
                '}';
    }
}

