package org.example.customer;

public abstract class AbCustomerFactory {

    abstract public CustomerBaseClass createCustomer();

    private String generateUniqueId() {
        return "This is Dummy ID";
    }
}
