package org.example.core;

import org.example.cmds.Command;
import org.example.interpreter.*;

// this can be a factory as well
public class CmdParser {
    public static Command parse(String input) {
        Expression expr;
        if ( input.matches("login|signin|signout") ) {
            expr = new GeneralExpr();
        } else if (input.startsWith("customer")) {
            expr = new CustomerExpr();
        } else if (input.startsWith("staff")) {
            expr = new StaffExpr();
        } else {
            expr = new EmptyExpr();
        }
        return expr.interpret(input);
    }

}
