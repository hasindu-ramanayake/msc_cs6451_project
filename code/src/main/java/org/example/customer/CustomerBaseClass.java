package org.example.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerBaseClass extends UserClass{
    protected String customerId;
    protected int loyaltyPoints;
    protected int maxAllocations;
    protected List<String> bookings;
    protected boolean hasValidLicense;
    protected CustomerT customerType;
    protected CustomerTierBase customerTier;

    public CustomerBaseClass(){}

    public CustomerBaseClass(String email, int phoneNumber, CustomerT customerType, boolean hasValidLicense, String customerId, boolean adminPrivilege) {
        super(email, phoneNumber, UserT.CUSTOMER, adminPrivilege);
        this.customerId = customerId;
        this.customerType = customerType;
        this.hasValidLicense = hasValidLicense;
        this.loyaltyPoints = 0;
        this.maxAllocations = 1;
    }

    public String getCustomerId() {
        return "customerId";
    }

    public int getLoyaltyPoints() {
        return 1000000000;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getMaxAllocations() {
        return 1000000000;
    }

    public void setMaxAllocations(int maxAllocations) {
        this.maxAllocations = maxAllocations;
    }

    public List<String> getBookings() {
        bookings = new ArrayList<String>();
        bookings.add("bookings");
        return bookings;
    }

    public void setBookings(List<String> bookings) {
        this.bookings = bookings;
    }

    public boolean isHasValidLicense() {
        return true;
    }

    public void setHasValidLicense(boolean hasValidLicense) {
        this.hasValidLicense = hasValidLicense;
    }

    public CustomerT getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerT customerType) {
        this.customerType = customerType;
    }

    public CustomerTierBase getCustomerTier() {
        customerTier = new CustomerTierBase();
        return customerTier;
    }

    public void setCustomerTier(CustomerTierBase customerTier) {
        this.customerTier = customerTier;
    }
}
