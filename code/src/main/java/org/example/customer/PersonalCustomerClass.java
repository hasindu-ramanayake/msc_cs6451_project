package org.example.customer;

public class PersonalCustomerClass extends CustomerBaseClass{

    private String lastName;
    private String firstName;

    public PersonalCustomerClass(String email, String phoneNumber, CustomerT customerType, boolean hasValidLicense, String customerId, String lastName, String firstName) {
        super(email, phoneNumber, customerType, hasValidLicense, customerId);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return "lastName";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return "firstName";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
