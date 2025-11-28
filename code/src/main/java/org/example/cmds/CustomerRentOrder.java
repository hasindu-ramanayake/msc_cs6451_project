package org.example.cmds;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;
import org.example.rental.IRentalOrder;
import org.example.rental.RentalMgr;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Date;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class CustomerRentOrder implements Command {
    private final String vehicleID;
    private Date date;

    public CustomerRentOrder(String vehicleID, String dateStr) {
        this.vehicleID = vehicleID;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.date = formatter.parse(dateStr);
        } catch (ParseException e) {
//            e.printStackTrace();
            System.out.println("The date format is wrong, you should use dd/MM/yyyy format.");
            this.date = null;
        }
    }

    @Override
    public void execute(SessionWrapper userSession) {
        ISingleton sessionMgr = SessionMgr.getInstance();
        if (((SessionMgr) sessionMgr).isValidSession(userSession) ) {
            if ( this.date == null ) return;
            ISingleton rentalMgr = RentalMgr.getInstance();
            String rentalOrderID = ((RentalMgr)rentalMgr).createRentalOrder(userSession.session.getUser(), vehicleID, date);
            if (rentalOrderID != null){
                System.out.println("The ID that corresponds to a this order is: " + rentalOrderID);
            }
            else {
                System.out.println("Unaccessible vehicle or invalid vehicle ID");
            }
        }
    }
}
