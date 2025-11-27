package org.example.customer;

import org.example.vehicle.VehicleGradeT;

import java.util.List;

public class CustomerTierGold extends CustomerTierBase{

    public CustomerTierGold() {
        super();
        super.bookingWindow = 1000000000;
        super.loyaltyPointMultiplier = 1.5;
        super.cancellationTime = 1000000000;
        super.loyaltyPointsToUpdate = 1000000000;
        super.vehicleGradeType = List.of(VehicleGradeT.ECONOMY, VehicleGradeT.STANDARD, VehicleGradeT.PREMIUM, VehicleGradeT.LUXURY);
        super.customerTierType = CustomerTierT.GOLD_TIER;
    }
}
