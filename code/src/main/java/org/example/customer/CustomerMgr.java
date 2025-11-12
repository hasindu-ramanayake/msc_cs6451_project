package org.example.customer;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;

import java.util.Map;

public class CustomerMgr implements ISingleton {
    private static ISingleton managerInst;
    private CustomerBaseClass customerFactory;
    private Map<String, CustomerBaseClass> customerMap;

    private CustomerMgr() {
    }

    public void addCustomer(){}

    public void removeCustomer(){}

    public void updateCustomerDetails(){}

    public void updateCustomerTier(){}

    public static ISingleton getInstance() {
        if ( managerInst == null) {
            managerInst = new CustomerMgr();
        }
        return managerInst;
    }

    public CustomerBaseClass getCustomerFromId(String customerId) {
        CustomerBaseClass customer = new CustomerBaseClass();
        return customer;
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE CUSTOMER MANAGER OBJECT: ");
    }
}
