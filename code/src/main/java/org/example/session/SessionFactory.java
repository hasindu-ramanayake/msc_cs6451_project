package org.example.session;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.ISingleton;
import org.example.core.LoggerFactory;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;

public class SessionFactory extends AbSessionFactory implements ISingleton {
    private static ISingleton factoryInstance;
    IDbAdapter db;
    private final ILogger logger;

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
        AbLoggerFactory lf = new LoggerFactory();
        this.logger = lf.createLogger();
        logger.debugMessage("CREATE SESSION MGR OBJECT: ");
        db = FileDbAdapter.getInstance();
    }

    @Override
    public void showMgrName() {
        logger.debugMessage("CREATE SESSION FACTORY OBJECT: ");
    }
}
