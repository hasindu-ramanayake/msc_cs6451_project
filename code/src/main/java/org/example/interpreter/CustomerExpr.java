package org.example.interpreter;

import org.example.cmds.*;

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

    public Command parseSearch(StringTokenizer inputTokens) {
        return new NoCmd();
    }
    public Command parseReceipt(StringTokenizer inputTokens) {
        return new NoCmd();
    }
    public Command parseRent(StringTokenizer inputTokens) {
        String toUpdate = inputTokens.nextToken();
        return switch (toUpdate) {
            case "viewall" -> new CustomerRentViewAll();
            default -> new NoCmd();
        };
    }
    public Command parseEvent(StringTokenizer inputTokens) {
        return new NoCmd();
    }

}



