package org.example.customer;

public class CustomerFactory implements ICustomerFactory{

    public ISingleton customerFactoryInstance;

    private CustomerFactory() {
    }

    @Override
    public CustomerBaseClass createCustomer() {
        return null;
    }

    public ISingleton getCustomerFactoryInstance() {
        return customerFactoryInstance;
    }
}
