package org.example.cmds;
import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;


public class AdminCheckNotfications implements Command{
    public AdminCheckNotfications(){

    }
    @Override
    public void execute(SessionWrapper userSession){
        ISingleton sessionMgr = SessionMgr.getInstance();
        if(((SessionMgr) sessionMgr).isValidSession(userSession)){
            //Needs to print all notifications


        }
    }
}
