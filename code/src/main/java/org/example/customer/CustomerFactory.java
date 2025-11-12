package org.example.customer;

import org.example.core.ISingleton;
import org.example.session.SessionFactory;

public class CustomerFactory extends AbCustomerFactory implements ISingleton {

    public ISingleton customerFactoryInstance;

    private CustomerFactory() {
    }

    @Override
    public CustomerBaseClass createCustomer() {
        return null;
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE CUSTOMER FACTORY OBJECT: ");
    }

    public ISingleton getCustomerFactoryInstance() {
        if ( customerFactoryInstance == null) {
            customerFactoryInstance = new CustomerFactory();
        }
        return customerFactoryInstance;
    }
}
