package org.example.customer;

import org.example.vehicle.VehicleGradeT;

import java.util.List;

public class CustomerTierPlatinum extends CustomerTierBase{

    public CustomerTierPlatinum() {
        super();
        this.bookingWindow = 30;
        this.loyaltyPointMultiplier = 1.5;
        this.cancellationTime = 1000000000;
        this.loyaltyPointsToUpdate = 1000000000;
        this.vehicleGradeType = List.of(VehicleGradeT.ECONOMY, VehicleGradeT.STANDARD, VehicleGradeT.PREMIUM);
        super.customerTierType = CustomerTierT.SILVER_TIER;
        this.discountMultiplier = 0.75f;
    }
}
