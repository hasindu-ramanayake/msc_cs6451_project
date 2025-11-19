package org.example.interpreter;

import org.example.cmds.Command;
import org.example.cmds.NoCmd;

public class EmptyExpr implements Expression {
    @Override
    public Command interpret(String input) {
        System.out.println("Command not found..!!");
        return new NoCmd();
    }
}
