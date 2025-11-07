package org.example.vehicle;

public class VehicleFactory {

    public static Vehicle createVehicle(String vehicleId, String manufacturer, String model,
                                        int year, double pricePerDay, VehicleCategory category) {
        return new Vehicle(vehicleId, manufacturer, model, year, pricePerDay,
                category, VehicleStatus.AVAILABLE);
    }
}
