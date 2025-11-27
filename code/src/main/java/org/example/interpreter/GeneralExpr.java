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
                System.out.println("Command help    > help ");
                System.out.println("Login user      > login [customerID]");
                System.out.println("SignUp user     > signup [customerID] [email] [phone number] [License ID]");
                System.out.println("Logout user     > signout ");
                System.out.println("Upgrade Tier    > customer upgrade tier ");
                System.out.println("Downgrade Tier  > customer downgrade tier ");
                System.out.println("Search accessible vehicles  > customer search all ");
                System.out.println("Search accessible vehicles by make  > customer search make ");
                System.out.println("Search accessible vehicles by date  > customer search date [DATE] ");
                System.out.println("View all rental orders  > customer rent view all ");
                System.out.println("View specific rental orders  > customer rent view [RentalID] ");
                System.out.println("Print specific rental orders receipt  > customer rent print [RentalID] ");
                System.out.println("Pay specific rental order  > customer rent pay [RentalID] ");
            }
        }
        return cmd;
    }

}
