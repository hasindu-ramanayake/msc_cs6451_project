package org.example.customer;

import java.util.List;

public class CustomerTierGold extends CustomerTierBase{

    public CustomerTierGold(int bookingWindow, float loyaltyPointMultiplier, int cancellationTime, int loyaltyPointsToUpdate, List<VehiculeGrade> vehicleGradeType, CustomerTierT customerTierType) {
        super(bookingWindow, loyaltyPointMultiplier, cancellationTime, loyaltyPointsToUpdate, vehicleGradeType, customerTierType);
    }
}
