package org.example.cmds;

import org.example.session.ISessionClass;
import org.example.session.SessionClass;

public class SignOut implements Command {
    public SignOut() { }
    @Override public void execute(ISessionClass userSession) {
        System.out.println("SignOut");
    }
}
