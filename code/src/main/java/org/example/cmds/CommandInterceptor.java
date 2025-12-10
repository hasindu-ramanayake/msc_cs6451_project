package org.example.cmds;

public interface CommandInterceptor {
    public void preCommand(CommandContext commandContext);
    public void postCommand(CommandContext commandContext);
}
