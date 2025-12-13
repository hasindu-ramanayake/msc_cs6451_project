package org.example.interpreter;

import org.example.cmds.Command;
import org.example.cmds.NoCmd;

import java.util.StringTokenizer;

public class CmdParser {
    public static Command parse(String input) {
        Expression expr;

        StringTokenizer inputTokens = new StringTokenizer(input);
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();

        String inputToken = inputTokens.nextToken();
        if ( inputToken.matches("login|signup|signout|help") ) {
            expr = new GeneralExpr();
        } else if (inputToken.startsWith("customer")) {
            expr = new CustomerExpr();
        } else if (inputToken.startsWith("staff")) {
            expr = new StaffExpr();
        }else if(inputToken.startsWith("admin")){
            expr = new AdminExp();
        }

        else {
            expr = new EmptyExpr();
        }

        return expr.interpret(input);
    }

}


