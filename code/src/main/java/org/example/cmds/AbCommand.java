package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public abstract class AbCommand implements Command {
    protected final ISingleton sessionMgr;

    public AbCommand(){
        this.sessionMgr = SessionMgr.getInstance();
    }

    protected boolean isSessionValid(SessionWrapper userSession){
        return ((SessionMgr)sessionMgr).isValidSession(userSession);
    }



}
