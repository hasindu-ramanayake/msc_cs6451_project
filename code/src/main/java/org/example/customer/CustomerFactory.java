package org.example.customer;

import org.example.core.ISingleton;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;
import org.example.session.SessionFactory;

public class CustomerFactory extends AbCustomerFactory implements ISingleton {

    private static ISingleton customerFactoryInstance;

    private CustomerFactory() {
    }

    @Override
    public CustomerBaseClass createCustomer(String email, String phoneNumber, CustomerT type, boolean hasValidLicense, String customerID) {
        if (type == CustomerT.PERSONAL_CUSTOMER) {
            return new PersonalCustomerClass(email, phoneNumber, type, hasValidLicense, customerID, "", "");
        }
        return new CustomerBaseClass();
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE CUSTOMER FACTORY OBJECT: ");
    }

    public static ISingleton getCustomerFactoryInstance() {
        if ( customerFactoryInstance == null) {
            customerFactoryInstance = new CustomerFactory();
        }
        return customerFactoryInstance;
    }
}
