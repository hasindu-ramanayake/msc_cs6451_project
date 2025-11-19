package org.example.cmds;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;
import org.example.customer.CustomerMgr;
import org.example.customer.CustomerT;
import org.example.customer.UserClass;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;

public class SignUp implements Command {
    private final String email;
    private final int phoneNumber;
    private final boolean hasValidLicense;
    private final String customerId;

    public SignUp(String email, int phoneNumber, String licenseID, String customerId){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasValidLicense = true;
        this.customerId = customerId;
    }
    @Override public void execute(SessionWrapper userSession) {
        ISingleton sessionMgr = SessionMgr.getInstance();
        ISingleton customerMgr = CustomerMgr.getInstance();
        ((CustomerMgr)customerMgr).createCustomerFromFactory(email, phoneNumber, CustomerT.PERSONAL_CUSTOMER, hasValidLicense, customerId);
        System.out.println("Signed up as " + customerId + "\n Email address: " + email + "\n Phone number: " + phoneNumber);
    }
}
