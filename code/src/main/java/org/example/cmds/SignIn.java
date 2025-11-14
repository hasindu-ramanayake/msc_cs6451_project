package org.example.cmds;

import org.example.session.ISessionClass;
import org.example.session.SessionClass;

public class SignIn implements Command {
    public SignIn(){}
    @Override public void execute(ISessionClass userSession) {
        System.out.println("SignIn");
    }
}
