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
            case "signin" -> {
                System.out.println("signin");
                cmd = new SignUp();
            }
            case "signout" -> {
                System.out.println("signout");
                cmd = new SignOut();
            }
        }
        return cmd;
    }

}
