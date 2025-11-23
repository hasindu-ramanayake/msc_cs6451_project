package org.example.rental;

import org.example.customer.CustomerBaseClass;
import org.example.vehicle.VehicleBaseClass;

import java.time.LocalDateTime;
import java.util.Date;

class RentalOrder implements IRentalOrder {
    private String orderId;
    private String customerId;
    private String vehicleId;
    private Date rentalDate;
    private float fee;
    private boolean isPaid;

    public RentalOrder(){

    }

    public RentalOrder(String customerId, String vehicleId, Date rentalDate, float fee, boolean isPaid) {
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.fee = fee;
        this.isPaid = isPaid;
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

