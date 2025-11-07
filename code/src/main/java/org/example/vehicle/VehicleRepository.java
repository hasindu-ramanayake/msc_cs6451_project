package org.example.vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private List<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added: " + vehicle.getModel());
    }

    public void removeVehicle(String vehicleId) {
        vehicles.removeIf(v -> v.getVehicleId().equals(vehicleId));
        System.out.println("Vehicle removed: " + vehicleId);
    }

    public void updateStatus(String vehicleId, VehicleStatus newStatus) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleId().equals(vehicleId)) {
                v.setStatus(newStatus);
                System.out.println("Updated status for " + v.getModel() + " to " + newStatus);
                return;
            }
        }
        System.out.println("Vehicle not found: " + vehicleId);
    }

    public void listVehicles() {
        System.out.println("\nAll Vehicles:");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> available = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getStatus() == VehicleStatus.AVAILABLE) {
                available.add(v);
            }
        }
        return available;
    }
}
