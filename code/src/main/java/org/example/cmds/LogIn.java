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

        userSession.cmdDispatcher.registerInterceptor(new LogInFormatInterceptor());
        CommandContext cmdContext = new CommandContext(userId);
        userSession.cmdDispatcher.processCommand(cmdContext);

        ISingleton sessionMgr = SessionMgr.getInstance();
        userSession.session = ((SessionMgr)sessionMgr).createSessionFromFactory(userId);

        if (userSession.session == null) {
            System.out.println("Invalid/Wrong User ID: Please try Again...!!");
            return;
        } else {
//            System.out.println(userSession.session.getSessionId());
            System.out.println("Welcome " + userId);
        }

    }
}
