package org.example.cmds;

import org.example.session.SessionClass;

public class SignIn implements Command {
    public SignIn(){}
    @Override public void execute(SessionClass userSession) {
        System.out.println("SignIn");
    }
}
