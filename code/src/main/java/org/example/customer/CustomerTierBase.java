package org.example.customer;

import java.util.List;

public class CustomerTierBase {
    private int bookingWindow;
    private float loyaltyPointMultiplier;
    private int cancellationTime;
    private int loyaltyPointsToUpdate;
    private List<VehiculeGrade> vehicleGradeType;
    private CustomerTierT customerTierType;

    public CustomerTierBase(int bookingWindow, float loyaltyPointMultiplier, int cancellationTime, int loyaltyPointsToUpdate, List<VehiculeGrade> vehicleGradeType, CustomerTierT customerTierType) {
        this.bookingWindow = bookingWindow;
        this.loyaltyPointMultiplier = loyaltyPointMultiplier;
        this.cancellationTime = cancellationTime;
        this.loyaltyPointsToUpdate = loyaltyPointsToUpdate;
        this.vehicleGradeType = vehicleGradeType;
        this.customerTierType = customerTierType;
    }

    public int getBookingWindow() {
        return bookingWindow;
    }

    public void setBookingWindow(int bookingWindow) {
        this.bookingWindow = bookingWindow;
    }

    public float getLoyaltyPointMultiplier() {
        return loyaltyPointMultiplier;
    }

    public void setLoyaltyPointMultiplier(float loyaltyPointMultiplier) {
        this.loyaltyPointMultiplier = loyaltyPointMultiplier;
    }

    public int getCancellationTime() {
        return cancellationTime;
    }

    public void setCancellationTime(int cancellationTime) {
        this.cancellationTime = cancellationTime;
    }

    public int getLoyaltyPointsToUpdate() {
        return loyaltyPointsToUpdate;
    }

    public void setLoyaltyPointsToUpdate(int loyaltyPointsToUpdate) {
        this.loyaltyPointsToUpdate = loyaltyPointsToUpdate;
    }

    public List<VehiculeGrade> getVehicleGradeType() {
        return vehicleGradeType;
    }

    public void setVehicleGradeType(List<VehiculeGrade> vehicleGradeType) {
        this.vehicleGradeType = vehicleGradeType;
    }

    public CustomerTierT getCustomerTierType() {
        return customerTierType;
    }

    public void setCustomerTierType(CustomerTierT customerTierType) {
        this.customerTierType = customerTierType;
    }
}
