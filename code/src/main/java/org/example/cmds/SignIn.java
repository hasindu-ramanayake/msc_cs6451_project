package org.example.cmds;

import org.example.session.ISessionClass;
import org.example.session.SessionClass;
import org.example.session.SessionWrapper;

public class SignIn implements Command {
    public SignIn(){}
    @Override public void execute(SessionWrapper userSession) {
        System.out.println("SignIn");
    }
}
