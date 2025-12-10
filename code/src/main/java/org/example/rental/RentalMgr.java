package org.example.rental;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;
import org.example.customer.CustomerTierT;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;
import org.example.payment.IPaymentGateway;

import java.util.ArrayList;

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

        if(!bookingWindow(customerId, rentDate)){
            return "Exceeds the Booking Date";
        }
        else{
            IRentalOrder rental = ((RentalFactory)rentalFactory).createRentalObject(customerId, vehicleId, rentDate);
            ((FileDbAdapter)db).addRentalOrder(rental);

            return rental.getOrderId();

        }


    }



    private boolean bookingWindow(String customerId, Date rentDate){
        CustomerBaseClass customer =((FileDbAdapter) db).getCustomer(customerId);
        CustomerTierT customerTier = customer.getCustomerTierType();

        int days = 0;

        if(customerTier == CustomerTierT.BRONZE_TIER){
            days = 3;
        }
        else if(customerTier == CustomerTierT.SILVER_TIER){
            days = 7;
        }
        else if(customerTier == CustomerTierT.GOLD_TIER){
            days = 14;
        }
        else if(customerTier == CustomerTierT.PLATINUM_TIER){
            days = 30;
        }


        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(
                java.time.LocalDate.now(),
                rentDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()
        );

        return daysBetween <= days;

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
