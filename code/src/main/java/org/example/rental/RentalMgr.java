
package org.example.rental;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.ISingleton;
import org.example.core.LoggerFactory;
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
    private ILogger logger;

    //Can only have one instance at a time
    public static ISingleton getInstance(){
        if(rentalInstance == null){
            rentalInstance = new RentalMgr();
        }
        return rentalInstance;
    }
    private RentalMgr () {
        rentalFactory = RentalFactory.getInstance();
        db = FileDbAdapter.getInstance();
        AbLoggerFactory log = new LoggerFactory();

    }

    @Override
    public void showMgrName(){
        logger.debugMessage("This is the Rental Manager");
    }



    //Other Functions
    public String createRentalOrder( String customerId, String vehicleId, Date rentDate, float discountPercentage){
        if ( !((FileDbAdapter)db).isValidVehicle(vehicleId) ) return null;
        if ( !((FileDbAdapter)db).isAccessibleVehical(customerId, vehicleId) ) return null;
        if ( !((FileDbAdapter)db).isAvailableVehical(vehicleId, rentDate) ) return null;
        if( !isWithinBookingWindow(customerId, rentDate)){ return "EBD";}

        IRentalOrder rental = ((RentalFactory)rentalFactory).createRentalObject(customerId, vehicleId, rentDate);
        if( discountPercentage != 0){
            DiscountData<Float> data = new DiscountData<>();
            data.value = discountPercentage;
            data.discountType = DiscountTypeT.DISCOUNT_CODE;
//            rental = ((RentalFactory)rentalFactory).addDiscountCode( rental, discountPercentage);
            rental = ((RentalFactory)rentalFactory).addDiscount( rental, data);
        }
        rental.printRentalOrder();
        ((FileDbAdapter)db).addRentalOrder(rental);
        return rental.getOrderId();
    }

    public float getDiscountPercentage(String discountCode){
        return db.getDiscountPercentage(discountCode);
    }

    private boolean isWithinBookingWindow(String customerId, Date rentDate){
        CustomerBaseClass customer =((FileDbAdapter) db).getCustomer(customerId);
        CustomerTierT customerTier = customer.getCustomerTierType();

        int days = customer.getCustomerTier().getBookingWindow();

        return  ( java.time.temporal.ChronoUnit.DAYS.between(
                java.time.LocalDate.now(),
                rentDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate()) <= days );
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

    //Function To Print Receipt
    public void printReceipt(String orderID){
        System.out.println(db.getRentalOrderFromID(orderID).printRentalOrder());
    }

}
