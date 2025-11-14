package org.example.interpreter;

import org.example.cmds.*;

import java.util.StringTokenizer;

public class GeneralExpr implements Expression {

    @Override
    public Command interpret(String input) {
        StringTokenizer inputTokens = new StringTokenizer(input);
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();
        String action = inputTokens.nextToken();
        return switch (action) {
            case "login" -> new LogIn();
            case "signin" -> new SignIn();
            case "signout" -> new SignOut();
            default -> new NoCmd();
        };
    }

}
