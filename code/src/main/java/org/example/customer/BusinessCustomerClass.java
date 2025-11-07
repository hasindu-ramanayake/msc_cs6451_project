package org.example.customer;

import java.util.Date;
import java.util.List;

public class BusinessCustomerClass extends CustomerBaseClass{

    private String companyName;

    public BusinessCustomerClass(String email, Date joinedDate, int phoneNumber, UserT userType, String customerId, int loyaltyPoints, int maxAllocations, List<String> bookings, boolean hasValidLicense, CustomerT customerType, CustomerTierBase customerTier, String companyName) {
        super(email, joinedDate, phoneNumber, userType, customerId, loyaltyPoints, maxAllocations, bookings, hasValidLicense, customerType, customerTier);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
