package org.example.db;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;
import org.example.rental.IRentalOrder;
import org.example.vehicle.MakeT;
import org.example.vehicle.VehicleBaseClass;

import java.util.ArrayList;
import java.util.Date;

public interface IDbAdapter {
    void readVehicleData(String source);
    void readCustomerData(String source);
    void readRentalData(String source);

    //customer check functions:
    public boolean isValidCustomer(String userId);
    public boolean isValidVehicle(String vehicleId);
    public void addCustomer(CustomerBaseClass cu);
    public boolean isAccessibleVehical(String customerId, String vehicleId);
    public boolean isAvailableVehical(String vehicleId, Date orderDate);
    public CustomerBaseClass getCustomer(String customerId);

    //get Vehicle data
    public ArrayList<VehicleBaseClass> getAccessibleVehicalList(String userId);
    public ArrayList<VehicleBaseClass> getAccessibleVehicalListByMake(String userId, MakeT make);
    public ArrayList<VehicleBaseClass> getAccessibleVehicalListByDate(String userId, Date date);

    //rental Orders
    public ArrayList<IRentalOrder> getRentalOrdersForCustomer(String userId);
    public void addRentalOrder(IRentalOrder rentalOrder);

    // add function to implement

    //TODO: Add functions to read vehicle data

    //Vehicle Functions

    public void updateVehicleState(VehicleBaseClass vehicle);
    public void removeVehicle(VehicleBaseClass vehicle);
    public void addVehicle(VehicleBaseClass vehicle);



}
