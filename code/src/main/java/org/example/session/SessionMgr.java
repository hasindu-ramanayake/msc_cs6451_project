package org.example.session;

import org.example.core.ISingleton;


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
    public boolean validateSession(String id) {return true;}
    public void deleteSession(String id) {}
    public ISessionClass createSessionFromFactory() {
        return ((SessionFactory)sessionFactory).createSession();
    }
    private void addSessionToSessionMap(ISessionClass session) {}
    private void requestCustomerDetails() {}
    private void requestVehicleDetails() {}

}
