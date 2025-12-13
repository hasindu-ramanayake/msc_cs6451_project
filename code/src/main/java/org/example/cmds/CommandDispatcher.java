package org.example.cmds;

import java.util.ArrayList;
import java.util.List;

public class CommandDispatcher {
    private List<CommandInterceptor> interceptors;

    public CommandDispatcher() {
        this.interceptors =  new ArrayList<>();
    }

    public void registerInterceptor(CommandInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void processCommand(CommandContext context) {
        for (CommandInterceptor interceptor : interceptors) {
            interceptor.preCommand(context);
        }
        interceptors.clear();
    }


}
