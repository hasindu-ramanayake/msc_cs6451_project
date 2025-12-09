package org.example.cmds;

import org.example.payment.PaymentContent;

public interface CommandInterceptor {
    public void preCommand(CommandContext commandContext);
    public void postCommand(CommandContext commandContext);
}
