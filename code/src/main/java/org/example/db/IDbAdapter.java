package org.example.db;

import org.example.customer.CustomerBaseClass;
import org.example.rental.IRentalOrder;
import org.example.vehicle.MakeT;
import org.example.vehicle.VehicleBaseClass;

import java.util.Date;
import java.util.List;

public interface IDbAdapter {
    void readVehicleData(String source);
    void readCustomerData(String source);
    void readRentalData(String source);
    public void readDiscountData(String source);

    //customer check functions:
    public boolean isValidCustomer(String userId);
    public boolean isValidVehicle(String vehicleId);
    public void addCustomer(CustomerBaseClass cu);
    public boolean isAccessibleVehical(String customerId, String vehicleId);
    public boolean isAvailableVehical(String vehicleId, Date orderDate);
    public CustomerBaseClass getCustomer(String customerId);

    //get Vehicle data
    public List<VehicleBaseClass> getAccessibleVehicalList(String userId);
    public List<VehicleBaseClass> getAccessibleVehicalListByMake(String userId, MakeT make);
    public List<VehicleBaseClass> getAccessibleVehicalListByDate(String userId, Date date);

    //rental Orders
    public List<IRentalOrder> getRentalOrdersForCustomer(String userId);
    public IRentalOrder getRentalOrderFromID(String orderID);
    public void addRentalOrder(IRentalOrder rentalOrder);

    //Vehicle Functions
    public void removeVehicle(VehicleBaseClass vehicle);
    public void addVehicle(VehicleBaseClass vehicle);

    //Discount Functions
    public float getDiscountPercentage(String discountName);

}
