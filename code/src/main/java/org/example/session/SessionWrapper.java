package org.example.session;

import org.example.cmds.CommandDispatcher;

public class SessionWrapper {
    public ISessionClass session;
    public final CommandDispatcher cmdDispatcher;
    public SessionWrapper() {
        this.session =null;
        this.cmdDispatcher = new CommandDispatcher();
    }
}
