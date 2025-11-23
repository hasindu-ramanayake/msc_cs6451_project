package org.example.interpreter;

import org.example.cmds.Command;
import org.example.cmds.CustomerDowngradeTier;
import org.example.cmds.CustomerUpgradeTier;
import org.example.cmds.NoCmd;

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
            case "all" ->{
                cmd = new CustomerSearchAll();
            }
            case "make" ->{
                if(!tokenizer.hasMoreTokens()){
                    return new NoCmd();
                }
                String make = tokenizer.nextToken();

            }

        };
        return cmd;


    }

    public Command parseReceipt(StringTokenizer tokenizer) {
        return new NoCmd();
    }
    public Command parseRent(StringTokenizer tokenizer) {
        return new NoCmd();
    }
    public Command parseEvent(StringTokenizer tokenizer) {
        return new NoCmd();
    }

}



