package org.example.cmds;

import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public class SignOut implements Command {
    public SignOut( ) { }

    @Override public void execute(SessionWrapper userSession) {
        if ( userSession == null ) {
            System.out.println("No user Session found..!!, Signing Out");
            return;
        }
        ((SessionMgr)SessionMgr.getInstance()).deleteSession(userSession);
    }
}
