package org.example.customer;

public abstract class AbCustomerFactory {

    abstract CustomerBaseClass createCustomer(String email, int phoneNumber, CustomerT type, boolean hasValidLicense, String customerID);

    private String generateUniqueId() {
        return "This is Dummy ID";
    }
}
