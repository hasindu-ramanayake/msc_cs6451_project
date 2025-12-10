package org.example.rental;

import org.example.core.RandomKeyGenerator;

import java.util.Date;

// Base Decorator
public abstract class RentalDecorator implements IRentalOrder {
    protected IRentalOrder decoratedRentalOrder;
    //Constructor
    protected RentalDecorator(IRentalOrder decoratedRentalOrder){
        this.decoratedRentalOrder = decoratedRentalOrder;
    }

    @Override public String generateId() { return RandomKeyGenerator.generateRandomKey(); }
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
    public Date getRentalDate(){
        return decoratedRentalOrder.getRentalDate();
    }

    @Override
    public String getVehicleId(){
        return decoratedRentalOrder.getVehicleId();
    }

    @Override
    public float getFee(){
        return decoratedRentalOrder.getFee();
    }

    @Override
    public boolean getIsPaid(){
        return decoratedRentalOrder.getIsPaid();
    }

    @Override
    public float getLoyaltyPoints(){
        return decoratedRentalOrder.getLoyaltyPoints();
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
    public void setRentalDate(Date rentalDate){
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
    public void setFee(float fee){
        decoratedRentalOrder.setFee(fee);
    }

    @Override
    public void setLoyaltyPoints(float loyaltyPoints) {
        decoratedRentalOrder.setLoyaltyPoints(loyaltyPoints);
    }
}
