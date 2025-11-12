package org.example.customer;

public abstract class AbCustomerFactory {

    abstract CustomerBaseClass createCustomer();

    private String generateUniqueId() {
        return "This is Dummy ID";
    }
}
