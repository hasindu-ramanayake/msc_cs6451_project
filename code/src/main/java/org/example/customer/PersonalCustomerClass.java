package org.example.customer;

import java.util.Date;
import java.util.List;

public class PersonalCustomerClass extends CustomerBaseClass{

    private String lastName;
    private String firstName;

    public PersonalCustomerClass() {
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
