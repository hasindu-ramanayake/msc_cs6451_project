package org.example.db;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;
import org.example.vehicle.MakeT;
import org.example.vehicle.VehicleBaseClass;

import java.util.ArrayList;

public interface IDbAdapter {
    void readVehicleData(String source);
    void readCustomerData(String source);
    void readRentalData(String source);

    //customer check functions:
    public boolean isValidCustomer(String userId);
    public void addCustomer(CustomerBaseClass cu);
    public CustomerBaseClass getCustomer(String customerId);

    //get Vehicle data
    public ArrayList<VehicleBaseClass> getAccessibleVehicalList(String userId);
    public ArrayList<VehicleBaseClass> getAccessibleVehicalListByMake(String userId, MakeT make);


    // add function to implement
}
