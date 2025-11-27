package org.example.customer;

import org.example.core.ISingleton;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;
import org.example.session.ISessionClass;
import org.example.session.SessionFactory;
import org.example.session.SessionMgr;

import java.util.HashMap;
import java.util.Map;

public class CustomerMgr implements ISingleton {
    private static ISingleton managerInst;
    private ISingleton customerFactory;
    private Map<String, CustomerBaseClass> customerMap;
    private IDbAdapter db;

    private CustomerMgr() {
        customerMap = new HashMap<>();
        customerFactory = CustomerFactory.getCustomerFactoryInstance();
        db = FileDbAdapter.getInstance();
    }

    public void addCustomer(CustomerBaseClass customer) {
        ((FileDbAdapter)db).addCustomer(customer);
    }

    public void removeCustomer(){}

    public void updateCustomerDetails(){}

    public void upgradeCustomerTier(String userId){
        CustomerBaseClass cu = ((FileDbAdapter)db).getCustomer(userId);
        if (cu == null) {
            System.out.println("Customer Not Found");
            return;
        }
        cu.upgradeCustomerTier();

    }

    public void downgradeCustomerTier(String userId) {
        CustomerBaseClass cu = ((FileDbAdapter)db).getCustomer(userId);
        if (cu ==null) {
            System.out.println("Customer Not Found");
            return;
        }
        cu.downgradeCustomerTier();

    }

    public static ISingleton getInstance() {
        if ( managerInst == null) {
            managerInst = new CustomerMgr();
        }
        return managerInst;
    }

    public CustomerBaseClass getCustomerFromId(String customerId) {
        CustomerBaseClass cu = ((FileDbAdapter)db).getCustomer(customerId);
        if (cu ==null) {
            System.out.println("Customer Not Found");
            return null;
        }

        return cu;
    }

    @Override
    public void showMgrName() {
        System.out.println("DEBUG: CREATE CUSTOMER MANAGER OBJECT: ");
    }

    public boolean createCustomerFromFactory(String email, String phoneNumber, CustomerT type, boolean hasValidLicense, String customerID) {
        CustomerBaseClass cu = ((CustomerFactory)customerFactory).createCustomer(email, phoneNumber, type, hasValidLicense, customerID);
        this.addCustomer(cu);
        return ((FileDbAdapter)db).isValidCustomer((cu.getCustomerId()));
    }
    public CustomerTierT getCustomerTier(String userID){
        return ((FileDbAdapter)db).getCustomer(userID).getCustomerTierType();
    }
}
