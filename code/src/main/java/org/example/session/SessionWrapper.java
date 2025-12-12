package org.example.session;

import org.example.cmds.CommandDispatcher;
import org.example.core.ISingleton;

public class SessionWrapper {
    public ISessionClass session;
    public final CommandDispatcher cmdDispatcher;
    public SessionWrapper() {
        this.session =null;
        this.cmdDispatcher = new CommandDispatcher();
    }

    public boolean isValidSession(){
        ISingleton sessionMgr = SessionMgr.getInstance();
        return ((SessionMgr) sessionMgr).isValidSession(this);

    }
}
