package org.example.cmds;

import org.example.core.ISingleton;

import org.example.session.ISessionClass;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public class LogIn implements Command {
    private final String userId;

    public LogIn(String userId){
        this.userId = userId;
    }

    @Override public void execute(SessionWrapper userSession) {
        System.out.println("LogIn");
        ISingleton sessionMgr = SessionMgr.getInstance();
        userSession.session = ((SessionMgr)sessionMgr).createSessionFromFactory(userId);
        assert (userSession.session == null) : "Session is null";
    }
}
