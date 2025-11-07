package org.example.vehicle;

public class Vehicle {
    private String vehicleId;
    private String manufacturer;
    private String model;
    private int year;
    private double pricePerDay;
    private VehicleCategory category;
    private VehicleStatus status;

    public Vehicle(String vehicleId, String manufacturer, String model, int year,
                   double pricePerDay, VehicleCategory category, VehicleStatus status) {
        this.vehicleId = vehicleId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.category = category;
        this.status = status;
    }

    public String getVehicleId() { return vehicleId; }
    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPricePerDay() { return pricePerDay; }
    public VehicleCategory getCategory() { return category; }
    public VehicleStatus getStatus() { return status; }

    public void setStatus(VehicleStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Vehicle ID: " + vehicleId +
                ", Manufacturer: " + manufacturer +
                ", Model: " + model +
                ", Year: " + year +
                ", Price/Day: " + pricePerDay +
                ", Category: " + category +
                ", Status: " + status;
    }
}
