package org.example.cmds;

import org.example.core.ISingleton;
import org.example.rental.RentalMgr;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public class CustomerRentPrint implements Command{
    private final String orderID;

    public CustomerRentPrint(String orderID){
        this.orderID = orderID;
    }

    @Override
    public void execute(SessionWrapper userSession){
        if (userSession.isValidSession()){
            ISingleton rentalMgr = RentalMgr.getInstance();
            ((RentalMgr)rentalMgr).printReceipt(orderID);
        }
    }
}
