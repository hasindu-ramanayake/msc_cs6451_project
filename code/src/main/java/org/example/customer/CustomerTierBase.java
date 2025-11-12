package org.example.customer;

import java.util.List;

public class CustomerTierBase {
    private int bookingWindow;
    private float loyaltyPointMultiplier;
    private int cancellationTime;
    private int loyaltyPointsToUpdate;
    private List<Integer> vehicleGradeType;
    private CustomerTierT customerTierType;

    public CustomerTierBase() {
    }

    public int getBookingWindow() {
        return 1000000000;
    }

    public void setBookingWindow(int bookingWindow) {
        this.bookingWindow = bookingWindow;
    }

    public float getLoyaltyPointMultiplier() {
        return 1000000000;
    }

    public void setLoyaltyPointMultiplier(float loyaltyPointMultiplier) {
        this.loyaltyPointMultiplier = loyaltyPointMultiplier;
    }

    public int getCancellationTime() {
        return 1000000000;
    }

    public void setCancellationTime(int cancellationTime) {
        this.cancellationTime = cancellationTime;
    }

    public int getLoyaltyPointsToUpdate() {
        return 1000000000;
    }

    public void setLoyaltyPointsToUpdate(int loyaltyPointsToUpdate) {
        this.loyaltyPointsToUpdate = loyaltyPointsToUpdate;
    }

    public List<Integer> getVehicleGradeType() {
        return vehicleGradeType;
    }

    public void setVehicleGradeType(List<Integer> vehicleGradeType) {
        this.vehicleGradeType = vehicleGradeType;
    }

    public CustomerTierT getCustomerTierType() {
        return customerTierType;
    }

    public void setCustomerTierType(CustomerTierT customerTierType) {
        this.customerTierType = customerTierType;
    }
}
