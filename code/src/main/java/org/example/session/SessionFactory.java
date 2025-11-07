package org.example.session;

import org.example.core.ISingleton;

public class SessionFactory extends AbSessionFactory implements ISingleton {
    private static ISingleton factoryInstance;

    public static ISingleton getInstance() {
        if ( factoryInstance == null) {
            factoryInstance = new SessionFactory();
        }
        return factoryInstance;
    }

    public ISessionClass createSession() {
        return new SessionClass();
    }

    private SessionFactory() {
        System.out.println("DEBUG: CREATE SESSION MGR OBJECT: ");

    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE SESSION FACTORY OBJECT: ");
    }
}
