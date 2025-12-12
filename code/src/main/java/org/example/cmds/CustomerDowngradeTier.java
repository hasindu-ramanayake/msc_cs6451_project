package org.example.cmds;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public class CustomerDowngradeTier implements Command {
    public CustomerDowngradeTier() {
    }

    @Override
    public void execute(SessionWrapper userSession) {
        if (userSession.isValidSession()){
            ISingleton customerMgr = CustomerMgr.getInstance();
            ((CustomerMgr)customerMgr).downgradeCustomerTier(userSession.session.getUser());
            System.out.println("You have been downgraded to: " + ((CustomerMgr)customerMgr).getCustomerTier(userSession.session.getUser()) + " for user " + userSession.session.getUser());
        }
    }
}
