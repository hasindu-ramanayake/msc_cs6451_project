package org.example.cmds;

import org.example.session.ISessionClass;
import org.example.session.SessionClass;

// TODO: need to add printable strategy here so we can print or change the Methods
public interface Command {
    // always check the userSession in null
    void execute(ISessionClass userSession);
}
