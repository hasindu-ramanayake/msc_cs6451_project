package org.example.interpreter;

import org.example.cmds.Command;

public interface Expression {
    public Command interpret(String input);
}
