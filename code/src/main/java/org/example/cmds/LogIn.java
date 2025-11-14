package org.example.cmds;

import org.example.core.ISingleton;
import org.example.core.JCRMain;
import org.example.core.MgrT;
import org.example.session.ISessionClass;
import org.example.session.SessionClass;
import org.example.session.SessionMgr;

public class LogIn implements Command {
    private String userId;

    public LogIn(String userId){
        this.userId = userId;
    }
    @Override public void execute(ISessionClass userSession) {
        System.out.println("LogIn");
        ISingleton jcrMain = JCRMain.getInstance();
        ISingleton sessionMgr = ((JCRMain)jcrMain).getMgrInstance(MgrT.SESSION_MGR);
        userSession = ((SessionMgr)sessionMgr).createSessionFromFactory(userId);


    }
}
