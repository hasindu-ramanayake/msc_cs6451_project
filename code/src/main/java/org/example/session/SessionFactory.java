package org.example.session;

import org.example.core.ISingleton;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;

public class SessionFactory extends AbSessionFactory implements ISingleton {
    private static ISingleton factoryInstance;
    IDbAdapter db;

    public static ISingleton getInstance() {
        if ( factoryInstance == null) {
            factoryInstance = new SessionFactory();
        }
        return factoryInstance;
    }

    public ISessionClass createSession(String userId) {
        if ( !db.isValidCustomer(userId) ) return null;
        String sessionId = this.generateUniqueId();
        return new SessionClass(userId, sessionId);
    }

    private SessionFactory() {
        System.out.println("DEBUG: CREATE SESSION MGR OBJECT: ");
        db = FileDbAdapter.getInstance();
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE SESSION FACTORY OBJECT: ");
    }
}
