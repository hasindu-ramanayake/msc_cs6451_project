package org.example.customer;

import java.util.Date;
import java.util.List;

public class PersonalCustomerClass extends CustomerBaseClass{

    private String lastName;
    private String firstName;

    public PersonalCustomerClass(String email, Date joinedDate, int phoneNumber, UserT userType, String customerId, int loyaltyPoints, int maxAllocations, List<String> bookings, boolean hasValidLicense, CustomerT customerType, CustomerTierBase customerTier, String lastName, String firstName) {
        super(email, joinedDate, phoneNumber, userType, customerId, loyaltyPoints, maxAllocations, bookings, hasValidLicense, customerType, customerTier);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
