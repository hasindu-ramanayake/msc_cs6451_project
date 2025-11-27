package org.example.rental;

import java.time.LocalDateTime;

class RentalOrder implements IRentalOrder {
    private String orderId;
    private String customerId;
    private String vehicleId;
    private LocalDateTime rentalDate;
    private float fee;
    private boolean isPaid;

    public RentalOrder(){

    }

    public RentalOrder(String orderId, String customerId, String vehicleId, LocalDateTime rentalDate, float fee, boolean isPaid) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.rentalDate = rentalDate;
        this.fee = fee;
        this.isPaid = isPaid;
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
    public LocalDateTime getRentalDate() {
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
    public void setRentalDate(LocalDateTime rentalDate) {
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
    public void setFee(double fee) {
        this.fee = (float) fee;

    }
}

