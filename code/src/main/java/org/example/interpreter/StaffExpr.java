package org.example.interpreter;

import org.example.cmds.Command;
import org.example.cmds.NoCmd;

import java.util.StringTokenizer;

public class StaffExpr implements  Expression {
    @Override
    public Command interpret(String input){
        StringTokenizer inputTokens = new StringTokenizer(input);
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();
        inputTokens.nextToken(); // skip customer token
        if ( !inputTokens.hasMoreTokens() ) return new NoCmd();

        // processing the second word
        String action = inputTokens.nextToken();

        if ( action.matches("report") ) {
            return parseReport(inputTokens);
        }
        return new NoCmd();
    }

    public Command parseReport(StringTokenizer tokenizer) {
        return new NoCmd();
    }
}
