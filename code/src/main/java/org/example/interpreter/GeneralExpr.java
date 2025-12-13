package org.example.interpreter;

import org.example.cmds.*;

import java.util.StringTokenizer;

public class GeneralExpr implements Expression {

    @Override
    public Command interpret(String input) {

        StringTokenizer inputTokens = new StringTokenizer(input);

        Command cmd = new NoCmd();
        if ( !inputTokens.hasMoreTokens() ) {return cmd; }
        String action = inputTokens.nextToken();

        switch (action) {
            case "login" -> {
                if ( !inputTokens.hasMoreTokens() ) { return cmd;}
                String userId = inputTokens.nextToken();
                cmd = new LogIn(userId);
            }
            case "signup" -> {
                if ( !inputTokens.hasMoreTokens() ) { return cmd;}
                String customerId = inputTokens.nextToken();
                if ( !inputTokens.hasMoreTokens() ) { return cmd;}
                String email = inputTokens.nextToken();
                if ( !inputTokens.hasMoreTokens() ) { return cmd;}
                String phoneNumber = inputTokens.nextToken();
                if ( !inputTokens.hasMoreTokens() ) { return cmd;}
                String hasValidLicense = inputTokens.nextToken();
                cmd = new SignUp(email, phoneNumber, hasValidLicense, customerId);
            }
            case "signout" -> {
                cmd = new SignOut();
            }
            case "help" -> {

                System.out.println("==============================================");
                System.out.println("           Available Commands                ");
                System.out.println("==============================================");
                System.out.printf("%-40s %-40s%n", "Command", "Description");
                System.out.println("----------------------------------------------");

                // Commands
                System.out.printf("%-40s %-40s%n", "help", "Show all available commands");
                System.out.printf("%-40s %-40s%n", "login [customerID]", "Login as a customer");
                System.out.printf("%-40s %-40s%n", "signup [customerID] [email] [phone] [License ID]", "Register a new customer");
                System.out.printf("%-40s %-40s%n", "signout", "Logout current user");
                System.out.printf("%-40s %-40s%n", "customer upgrade tier", "Upgrade customer tier");
                System.out.printf("%-40s %-40s%n", "customer downgrade tier", "Downgrade customer tier");
                System.out.printf("%-40s %-40s%n", "customer search all", "Search all accessible vehicles");
                System.out.printf("%-40s %-40s%n", "customer search make", "Search vehicles by make");
                System.out.printf("%-40s %-40s%n", "customer search date [DATE]", "Search vehicles by date");
                System.out.printf("%-40s %-40s%n", "customer rent view all", "View all rental orders");
                System.out.printf("%-40s %-40s%n", "customer rent view [RentalID]", "View specific rental order");
                System.out.printf("%-40s %-40s%n", "customer rent order [VehicleID] [Date {DD/MM/YYYY}] [DiscountCode](optional)", "rent a vehicle on a date");
                System.out.printf("%-40s %-40s%n", "customer rent print [RentalID]", "Print rental order receipt");
                System.out.printf("%-40s %-40s%n", "customer rent pay [RentalID]", "Pay for a rental order");
                System.out.println("==============================================");

            }
        }
        return cmd;
    }

}
