package org.example.session;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.ISingleton;
import org.example.core.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class SessionMgr implements ISingleton {
    private static ISingleton sessionInst;
    private static ISingleton sessionFactory;

    private final ILogger logger;

    public static ISingleton getInstance() {
        if ( sessionInst == null) {
            sessionInst = new SessionMgr();
        }
        return sessionInst;
    }
    private SessionMgr() {
        AbLoggerFactory log = new LoggerFactory();
        this.logger = log.createLogger();
        logger.debugMessage("CREATE SESSION MGR OBJECT: ");
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void showMgrName() {
        logger.debugMessage("CREATE SESSION MGR OBJECT");
    }

    // Other Functions:
    public boolean isValidSession(SessionWrapper userSession) {
        if ( userSession.session != null && userSession.session.isExpired() ) {
            return true;
        }
        this.deleteSession(userSession);
        return false;
    }

    public void deleteSession(SessionWrapper userSession) {
        userSession.session = null;
    }

    public ISessionClass createSessionFromFactory(String userId) {
        return ((SessionFactory)sessionFactory).createSession(userId);
    }

}
