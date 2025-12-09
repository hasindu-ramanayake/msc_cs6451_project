package org.example.cmds;

public class LogInFormatInterceptor implements CommandInterceptor{
    @Override
    public void preCommand(CommandContext commandContext) {
        if (!commandContext.getUserID().startsWith("C00")) {
            System.out.println("Invalid user ID detected!");
        }
    }

    @Override
    public void postCommand(CommandContext commandContext) {
        System.out.println("[LOGIN] User ID verified.");
    }
}
