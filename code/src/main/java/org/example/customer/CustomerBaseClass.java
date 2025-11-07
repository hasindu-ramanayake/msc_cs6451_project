package org.example.customer;

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

    public CustomerBaseClass(String email, Date joinedDate, int phoneNumber, UserT userType, String customerId, int loyaltyPoints, int maxAllocations, List<String> bookings, boolean hasValidLicense, CustomerT customerType, CustomerTierBase customerTier) {
        super(email, joinedDate, phoneNumber, userType);
        this.customerId = customerId;
        this.loyaltyPoints = loyaltyPoints;
        this.maxAllocations = maxAllocations;
        this.bookings = bookings;
        this.hasValidLicense = hasValidLicense;
        this.customerType = customerType;
        this.customerTier = customerTier;
    }

    public String getCustomerId() {
        return customerId;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getMaxAllocations() {
        return maxAllocations;
    }

    public void setMaxAllocations(int maxAllocations) {
        this.maxAllocations = maxAllocations;
    }

    public List<String> getBookings() {
        return bookings;
    }

    public void setBookings(List<String> bookings) {
        this.bookings = bookings;
    }

    public boolean isHasValidLicense() {
        return hasValidLicense;
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
        return customerTier;
    }

    public void setCustomerTier(CustomerTierBase customerTier) {
        this.customerTier = customerTier;
    }
}
