package org.example.core;

import org.example.cmds.Command;
import org.example.cmds.NoCmd;
import org.example.interpreter.*;

import java.util.StringTokenizer;

// this can be a factory as well
public class CmdParser {
    public static Command parse(String input) {
        Expression expr;

        StringTokenizer inputTokens = new StringTokenizer(input);
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();

        String inputToken = inputTokens.nextToken();
        if ( inputToken.matches("login|signin|signout") ) {
            expr = new GeneralExpr();
        } else if (inputToken.startsWith("customer")) {
            expr = new CustomerExpr();
        } else if (inputToken.startsWith("staff")) {
            expr = new StaffExpr();
        } else {
            expr = new EmptyExpr();
        }

        return expr.interpret(input);
    }

}
