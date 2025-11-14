package org.example.cmds;

import org.example.session.SessionClass;

public class LogIn implements Command {
    public LogIn(){}
    @Override public void execute(SessionClass userSession){
        System.out.println("LogIn");
    }
}
