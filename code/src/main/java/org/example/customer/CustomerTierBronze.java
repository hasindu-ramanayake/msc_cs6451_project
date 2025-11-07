package org.example.customer;

import java.util.List;

public class CustomerTierBronze extends CustomerTierBase{
    public CustomerTierBronze(int bookingWindow, float loyaltyPointMultiplier, int cancellationTime, int loyaltyPointsToUpdate, List<VehiculeGrade> vehicleGradeType, CustomerTierT customerTierType) {
        super(bookingWindow, loyaltyPointMultiplier, cancellationTime, loyaltyPointsToUpdate, vehicleGradeType, customerTierType);
    }
}
