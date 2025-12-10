package org.example.customer;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.ISingleton;
import org.example.core.LoggerFactory;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;
import org.example.session.ISessionClass;
import org.example.session.SessionFactory;
import org.example.session.SessionMgr;

import java.util.HashMap;
import java.util.Map;

public class CustomerMgr implements ISingleton {
    private static ISingleton managerInst;
    private final ISingleton customerFactory;
    private final IDbAdapter db;
    private ILogger logger;

    private CustomerMgr() {
        customerFactory = CustomerFactory.getCustomerFactoryInstance();
        db = FileDbAdapter.getInstance();
        AbLoggerFactory log = new LoggerFactory();
        this.logger = log.createLogger();

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

        logger.debugMessage("CREATE CUSTOMER MANAGER OBJECT: ");
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
