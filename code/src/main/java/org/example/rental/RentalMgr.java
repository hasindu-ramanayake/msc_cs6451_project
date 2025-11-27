package org.example.rental;

import org.example.core.ISingleton;
import org.example.payment.IPaymentGateway;

import java.time.LocalDateTime;
import java.util.HashMap;

public class RentalMgr implements ISingleton{
    private static ISingleton rentalInstance;
    private static ISingleton rentalFactory;
    private HashMap<String, IRentalOrder> rentalOrderMap;
    public IPaymentGateway paymentGateway;

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
        rentalOrderMap = new HashMap<>();
        rentalFactory = RentalFactory.getInstance();
    }

    //Other Functions
    public void initialiseRentalOrder(){}
    public void requestPayment(){}
    private String getRentalOrderID(String orderId){
        return orderId;
    }

    public HashMap<String, IRentalOrder> getAllRentalOrdersForCustomer(String customerID){
        HashMap<String, IRentalOrder> result = new HashMap<>();

        for (var entry : rentalOrderMap.entrySet()) {
            IRentalOrder order = entry.getValue();
            if (order instanceof RentalOrder rentalOrder) {
                if (rentalOrder.getCustomerId().equals(customerID)) {
                    result.put(entry.getKey(), rentalOrder);
                }
            }
        }
        return result;
    }

    public void printAllRentalOrders(HashMap<String, IRentalOrder> allRentalOrders) {
        for (var entry : allRentalOrders.entrySet()) {
            IRentalOrder order = entry.getValue();
            System.out.println("Rental ID: " + entry.getKey());
            System.out.println("Customer ID: " + order.getCustomerId());
            System.out.println("Vehicle ID: " + order.getVehicleId());
            System.out.println("Location Date: " + order.getRentalDate());
            System.out.println("Location Fee: " + order.getFee());
            System.out.println("Payment Status: " + (order.getIsPaid() ? "Paid" : "Not Paid"));
            System.out.println("-----------------------------");
        }
    }

    public String getRentalOrderID(HashMap<String, IRentalOrder> rentalMap, String vehicleID, LocalDateTime date) {
        for (var entry : rentalMap.entrySet()) {
            IRentalOrder order = entry.getValue();
            if (order.getVehicleId().equals(vehicleID) && order.getRentalDate().equals(date)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
