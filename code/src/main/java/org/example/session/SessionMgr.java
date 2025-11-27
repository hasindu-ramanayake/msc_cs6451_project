package org.example.session;

import org.example.core.ISingleton;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class SessionMgr implements ISingleton {
    private static ISingleton sessionInst;
    private static ISingleton sessionFactory;

    public static ISingleton getInstance() {
        if ( sessionInst == null) {
            sessionInst = new SessionMgr();
        }
        return sessionInst;
    }
    private SessionMgr() {
        System.out.println("DEBUG: CREATE SESSION MGR OBJECT: ");
        sessionFactory = SessionFactory.getInstance();
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE SESSION MGR OBJECT: ");
    }

    // Other Functions:
    public boolean isValidSession(SessionWrapper userSession) {
        if ( userSession.session != null && ChronoUnit.MINUTES.between(userSession.session.getLastTimeStamp(), LocalDateTime.now()) <= 5 ) {
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
//    private void addSessionToSessionMap(ISessionClass session) {}
//    private void requestCustomerDetails() {}
//    private void requestVehicleDetails() {}

}
