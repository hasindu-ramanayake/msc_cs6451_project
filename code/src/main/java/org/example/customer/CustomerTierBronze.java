package org.example.customer;

import org.example.vehicle.VehicleGradeT;

import java.util.List;

public class CustomerTierBronze extends CustomerTierBase{
    public CustomerTierBronze() {
        super();
        this.bookingWindow = 1000000000;
        this.loyaltyPointMultiplier = 1.5;
        this.cancellationTime = 1000000000;
        this.loyaltyPointsToUpdate = 1000000000;
        this.vehicleGradeType = List.of(VehicleGradeT.ECONOMY, VehicleGradeT.STANDARD);
        this.customerTierType = CustomerTierT.BRONZE_TIER;
    }
}