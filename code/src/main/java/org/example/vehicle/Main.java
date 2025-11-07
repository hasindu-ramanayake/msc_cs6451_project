package org.example.vehicle;

public class Main {
    public static void main(String[] args) {
        VehicleRepository repo = new VehicleRepository();

        Vehicle v1 = VehicleFactory.createVehicle("V001", "Toyota", "Corolla", 2022, 50.0, VehicleCategory.ECONOMY);
        Vehicle v2 = VehicleFactory.createVehicle("V002", "BMW", "X5", 2023, 120.0, VehicleCategory.LUXURY);

        repo.addVehicle(v1);
        repo.addVehicle(v2);

        repo.listVehicles();

        repo.updateStatus("V001", VehicleStatus.RENTED);
    }
}

