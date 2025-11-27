package org.example.rental;

import java.time.LocalDateTime;

// Base Decorator
public abstract class RentalDecorator implements IRentalOrder {
    protected IRentalOrder decoratedRentalOrder;
    //Constructor
    public RentalDecorator(IRentalOrder decoratedRentalOrder){
        this.decoratedRentalOrder = decoratedRentalOrder;
    }

    //Override the Methods
    @Override
    public String getOrderId(){
        return decoratedRentalOrder.getOrderId();
    }
    @Override
    public String getCustomerId(){
        return decoratedRentalOrder.getCustomerId();
    }

    @Override
    public LocalDateTime getRentalDate(){
        return decoratedRentalOrder.getRentalDate();
    }

    @Override
    public String getVehicleId(){
        return decoratedRentalOrder.getVehicleId();
    }

    @Override
    public double getFee(){
        return decoratedRentalOrder.getFee();
    }

    @Override
    public boolean getIsPaid(){
        return decoratedRentalOrder.getIsPaid();
    }

    @Override
    public String printRentalOrder(){
        return decoratedRentalOrder.printRentalOrder();
    }

    @Override
    public void setCustomerId(String customerId){
        decoratedRentalOrder.setCustomerId(customerId);
    }

    @Override
    public void setRentalDate(LocalDateTime rentalDate){
        decoratedRentalOrder.setRentalDate(rentalDate);
    }

    @Override
    public void setVehicleId(String vehicleId){
        decoratedRentalOrder.setVehicleId(vehicleId);
    }

    @Override
    public void setIsPaid(boolean isPaid){
        decoratedRentalOrder.setIsPaid(isPaid);
    }

    @Override
    public void setFee(double fee){
        decoratedRentalOrder.setFee(fee);
    }
}
