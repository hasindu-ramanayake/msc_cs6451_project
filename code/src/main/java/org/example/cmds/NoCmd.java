package org.example.cmds;

import org.example.session.ISessionClass;
import org.example.session.SessionClass;
import org.example.session.SessionWrapper;

public class NoCmd implements Command{
    public NoCmd(){}
    @Override public void execute(SessionWrapper userSession){}
}
