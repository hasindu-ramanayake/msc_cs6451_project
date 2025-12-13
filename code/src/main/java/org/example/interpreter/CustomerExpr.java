package org.example.interpreter;

import org.example.cmds.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class CustomerExpr implements Expression {
    @Override
    public Command interpret(String input) {
        StringTokenizer inputTokens = new StringTokenizer(input);

        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();
        inputTokens.nextToken(); // skip customer token
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();

        // processing the second word
        String action = inputTokens.nextToken();

        return switch (action) {
            case "upgrade" -> parseUpgrade(inputTokens);
            case "downgrade" -> parseDowngrade(inputTokens);
            case "search" -> parseSearch(inputTokens);
            case "receipt" -> parseReceipt(inputTokens);
            case "rent" -> parseRent(inputTokens);
            case "event" -> parseEvent(inputTokens);
            default -> new NoCmd();
        };
    }

    public Command parseUpgrade(StringTokenizer inputTokens) {
        String toUpdate = inputTokens.nextToken();
        return switch (toUpdate) {
            case "tier" -> new CustomerUpgradeTier();
            default -> new NoCmd();
        };
    }

    public Command parseDowngrade(StringTokenizer inputTokens) {
        String toUpdate = inputTokens.nextToken();
        return switch (toUpdate) {
            case "tier" -> new CustomerDowngradeTier();
            default -> new NoCmd();
        };
    }

    public Command parseSearch(StringTokenizer tokenizer) {
        Command cmd = new NoCmd();
        if(!tokenizer.hasMoreTokens()){
            return new NoCmd();
        }
        String searchFor = tokenizer.nextToken();

        switch(searchFor){
            case "all" -> {
                cmd = new CustomerSearchAll();
            }case "make" -> {
                if ( !tokenizer.hasMoreTokens() ) return new NoCmd();
                String make = tokenizer.nextToken();
                cmd = new CustomerSearchMake(make);
            }case "date"->{
                if ( !tokenizer.hasMoreTokens() ) return new NoCmd();
                String date = tokenizer.nextToken();
                cmd = new CustomerSearchDate(date);
            }
            default ->{
                return new NoCmd();
            }
        }
        return cmd;

    }

    public Command parseReceipt(StringTokenizer tokenizer) {
        String next = tokenizer.nextToken();
        Command cmd = new NoCmd();
        switch (next){
            case "viewall" ->{
                cmd = new CustomerRentViewAll();
            }
        }
        return cmd;
    }

    public Command parseRent(StringTokenizer inputTokens) {
        String next = inputTokens.nextToken();
        Command cmd = new NoCmd();
        switch (next) {
            case "viewall" : {
                cmd = new CustomerRentViewAll();
                break;
            } case "order" : {
                if (inputTokens.countTokens() == 2 ) {
                    String vehicleId = inputTokens.nextToken();
                    String dateToken = inputTokens.nextToken();
                    System.out.println(vehicleId+" "+dateToken);
                    cmd = new CustomerRentOrder(vehicleId, dateToken);
                }
                else if (inputTokens.countTokens() == 3 ) {
                    String vehicleId = inputTokens.nextToken();
                    String dateToken = inputTokens.nextToken();
                    String discountCode = inputTokens.nextToken();
                    System.out.println(vehicleId + " " + dateToken + " " + discountCode);
                    cmd = new CustomerRentOrder(vehicleId, dateToken, discountCode);
                }else {
                    System.out.println("Format error> customer rent order [VehicleId] [data{DD/MM/YYYY}] [Discount code (optional)]");
                }
                break;
            } case "print" : {
                String orderId = inputTokens.nextToken();
                cmd = new CustomerRentPrint(orderId);
                break;
            }
            default: assert(true);
        }
        return cmd;
    }

    public Command parseEvent(StringTokenizer inputTokens) {
        return new NoCmd();
    }

}



