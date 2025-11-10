package org.example.rental;

import org.example.core.ISingleton;
import org.example.payment.IPaymentGateway;

import java.util.HashMap;

public class RentalMgr implements ISingleton{
    private static ISingleton rentalInstance;
    private static ISingleton rentalFactory;
    private HashMap<String , IRentalOrder> rentalOrderMap;
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
        System.out.println("DEBUG: CREATE RENTAL MANAGER");

    }


    //Other Functions
    public void initialiseRentalOrder(){}
    public void requestPayment(){}
    private String getRentalOrder(String orderId){
        return "rentalOrder";
    }


}
