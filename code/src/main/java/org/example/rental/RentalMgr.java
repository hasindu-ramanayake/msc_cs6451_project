package org.example.rental;

import org.example.core.ISingleton;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;
import org.example.payment.IPaymentGateway;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class RentalMgr implements ISingleton{
    private static ISingleton rentalInstance;
    private static ISingleton rentalFactory;
    private IPaymentGateway paymentGateway;
    private IDbAdapter db;

    //Can only have one instance at a time
    public static ISingleton getInstance(){
        if(rentalInstance == null){
            rentalInstance = new RentalMgr();
        }
        return rentalInstance;
    }

    @Override
    public void showMgrName(){
        System.out.println("This is the Rental Manager");
    }

    private RentalMgr () {
        rentalFactory = RentalFactory.getInstance();
        db = FileDbAdapter.getInstance();
    }

    //Other Functions
    public String createRentalOrder( String customerId, String vehicleId, Date rentDate){
        if ( !((FileDbAdapter)db).isValidVehicle(vehicleId) ) return null;
        if ( !((FileDbAdapter)db).isAccessibleVehical(customerId, vehicleId) ) return null;
        if ( !((FileDbAdapter)db).isAvailableVehical(vehicleId, rentDate) ) return null;

        IRentalOrder rental = ((RentalFactory)rentalFactory).createRentalObject(customerId, vehicleId, rentDate);
        ((FileDbAdapter)db).addRentalOrder(rental);
        return rental.getOrderId();
    }

    public void requestPayment(){}
    private String getRentalOrderID(String orderId){
        return orderId;
    }

    public ArrayList<IRentalOrder> getAllRentalOrdersForCustomer(String customerID){
        return ((FileDbAdapter)db).getRentalOrdersForCustomer(customerID);
    }

    public String getRentalOrderIDForCustomer(String customerID, String vehicleID, Date date) {
//        ArrayList<IRentalOrder> rentalMap = getAllRentalOrdersForCustomer(customerID);
//        for (var entry : rentalMap.entrySet()) {
//            IRentalOrder order = entry.getValue();
//            if (order.getVehicleId().equals(vehicleID) && order.getRentalDate().equals(date)) {
//                return entry.getKey();
//            }
//        }
        return null;
    }
}
