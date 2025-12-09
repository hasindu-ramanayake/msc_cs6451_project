package org.example.cmds;

import org.example.core.ISingleton;
import org.example.rental.IRentalOrder;
import org.example.rental.RentalMgr;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

import java.util.ArrayList;

public class CustomerRentViewAll implements Command{

    public CustomerRentViewAll() {
    }

    @Override
    public void execute(SessionWrapper userSession) {
        ISingleton sessionMgr = SessionMgr.getInstance();
        if (((SessionMgr)sessionMgr).isValidSession(userSession)) {
            ISingleton rentalMgr = RentalMgr.getInstance();

            ArrayList<IRentalOrder> rentalList = ((RentalMgr)rentalMgr).getAllRentalOrdersForCustomer(userSession.session.getUser());
            for (IRentalOrder r: rentalList) {
                System.out.println(((RentalMgr) rentalMgr).printReceipt(r));
                System.out.println(" ");

            }
        }
    }
}
