package org.example.customer;

public abstract class AbCustomerFactory {

    abstract CustomerBaseClass createCustomer(String email, String phoneNumber, CustomerT type, boolean hasValidLicense, String customerID);

}