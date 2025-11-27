package org.example.db;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;

public interface IDbAdapter {
    void readVehicleData(String source);
    void readCustomerData(String source);
    void readRentalData(String source);

    //customer check functions:
    public boolean isValidCustomer(String userId);
    public void addCustomer(CustomerBaseClass cu);
    public CustomerBaseClass getCustomer(String customerId);
    // add function to implement
}
