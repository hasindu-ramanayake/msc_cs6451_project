package org.example.cmds;

import org.example.session.SessionWrapper;

public class SignUp implements Command {
    public SignUp(){}
    @Override public void execute(SessionWrapper userSession) {
        System.out.println("SignIn");
    }
}
