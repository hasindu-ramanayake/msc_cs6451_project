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

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CustomerRentOrder implements Command {
    private final String vehicleID;
    private final LocalDateTime date;

    public CustomerRentOrder(String vehicleID, String dateStr) {
        this.vehicleID = vehicleID;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime tempDate;
        try {
            tempDate = LocalDate.parse(dateStr, formatter).atStartOfDay();
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            tempDate = LocalDateTime.now();
        }
        this.date = tempDate;
    }

    public CustomerRentOrder(String vehicleID, LocalDateTime date) {
        this.vehicleID = vehicleID;
        this.date = date;
    }

    @Override
    public void execute(SessionWrapper userSession) {
        System.out.println("Get OrderID...");
        ISingleton sessionMgr = SessionMgr.getInstance();
        if (((SessionMgr) sessionMgr).isValidSession(userSession)) {
            ISingleton rentalMgr = RentalMgr.getInstance();
            HashMap<String, IRentalOrder> rentalMap = ((RentalMgr) rentalMgr).getAllRentalOrdersForCustomer(userSession.session.getUser());
            String rentalOrderID = ((RentalMgr)rentalMgr).getRentalOrderID(rentalMap, vehicleID, date);
            if (rentalOrderID != null){
                System.out.println("The ID that corresponds to a this order is: " + rentalOrderID);
            }
            else {
                System.out.println("There is no order corresponding.");
            }
        }
    }
}
