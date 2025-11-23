package org.example.customer;

import org.example.core.ISingleton;
import org.example.session.ISessionClass;
import org.example.session.SessionFactory;
import org.example.session.SessionMgr;

import java.util.HashMap;
import java.util.Map;

public class CustomerMgr implements ISingleton {
    private static ISingleton managerInst;
    private ISingleton customerFactory;
    private Map<String, CustomerBaseClass> customerMap;

    private CustomerMgr() {
        customerMap = new HashMap<>();
        customerFactory = CustomerFactory.getCustomerFactoryInstance();
    }

    public void addCustomer(String customerId, CustomerBaseClass customer) {
        customerMap.put(customerId, customer);
    }

    public void removeCustomer(){}

    public void updateCustomerDetails(){}

    public void upgradeCustomerTier(String userId){
        customerMap.get(userId).upgradeCustomerTier();

    }

    public void downgradeCustomerTier(String userId){
        customerMap.get(userId).downgradeCustomerTier();

    }

    public static ISingleton getInstance() {
        if ( managerInst == null) {
            managerInst = new CustomerMgr();
        }
        return managerInst;
    }

    public CustomerBaseClass getCustomerFromId(String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            System.out.println("DEBUG: Invalid customerId");
            return null;
        }

        if (customerMap == null) {
            System.out.println("DEBUG: customerMap is null");
            return null;
        }

        CustomerBaseClass customer = customerMap.get(customerId);

        if (customer == null) {
            System.out.println("DEBUG: No customer found with id " + customerId);
        }

        return customer;
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE CUSTOMER MANAGER OBJECT: ");
    }

    public void createCustomerFromFactory(String email, int phoneNumber, CustomerT type, boolean hasValidLicense, String customerID) {
        CustomerBaseClass cu = ((CustomerFactory)customerFactory).createCustomer(email, phoneNumber, type, hasValidLicense, customerID);
        customerMap.put(customerID, cu);
        if (cu == null) System.out.println("DEBUG: cu is null: " + customerMap.size());
    }
    public CustomerTierT getCustomerTier(String userID){
        return customerMap.get(userID).getCustomerTierType();
    }
}
