package org.example.db;

public interface IDbAdapter {
    void readVehicleData(String source);
    void readCustomerData(String source);
    void readRentalData(String source);
    // add function to implement
}
