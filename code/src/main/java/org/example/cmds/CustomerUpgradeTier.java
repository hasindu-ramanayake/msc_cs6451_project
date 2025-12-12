package org.example.cmds;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public class CustomerUpgradeTier implements Command {
    public CustomerUpgradeTier() {
    }

    @Override
    public void execute(SessionWrapper userSession) {
        System.out.println("Upgrade Tier");
        if (userSession.isValidSession()){
            ISingleton customerMgr = CustomerMgr.getInstance();
            ((CustomerMgr)customerMgr).upgradeCustomerTier(userSession.session.getUser());
            System.out.println("You have been upgraded to: " + ((CustomerMgr)customerMgr).getCustomerTier(userSession.session.getUser()) + " for user " + userSession.session.getUser());
        }
    }
}
