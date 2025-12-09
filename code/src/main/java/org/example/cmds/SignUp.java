package org.example.cmds;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;
import org.example.customer.CustomerT;
import org.example.session.SessionWrapper;

public class SignUp implements Command {
    private final String email;
    private final String phoneNumber;
    private final boolean hasValidLicense;
    private final String customerId;

    public SignUp(String email, String phoneNumber, String licenseID, String customerId){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hasValidLicense = true;
        this.customerId = customerId;
    }
    @Override public void execute(SessionWrapper userSession) {
        ISingleton customerMgr = CustomerMgr.getInstance();
        if ( ((CustomerMgr)customerMgr).createCustomerFromFactory(email, phoneNumber, CustomerT.PERSONAL_CUSTOMER, hasValidLicense, customerId) ) {
            System.out.println("Signed up as " + customerId + "\n Please login using > login "+ customerId );
        } else {
            System.out.println("SigUp error: Please try later");
        }
    }
}
