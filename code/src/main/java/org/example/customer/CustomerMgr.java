package org.example.customer;

import java.util.Map;

public class CustomerMgr {
    private CustomerBaseClass customerFactory;
    private Map<String, CustomerBaseClass> customerMap;

    public CustomerMgr() {
    }

    public void addCustomer(){}

    public void removeCustomer(){}

    public void updateCustomerDetails(){}

    public void updateCustomerTier(){}

    public CustomerBaseClass getCustomerFromId(String customerId) {
        CustomerBaseClass customer = new CustomerBaseClass();
        return customer;
    }
}
