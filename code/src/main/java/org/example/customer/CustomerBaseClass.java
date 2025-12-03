package org.example.customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerBaseClass extends UserClass{
    protected String customerId;
    protected int loyaltyPoints;
    protected int maxAllocations;
//    protected List<String> bookings;
    protected boolean hasValidLicense;
    protected CustomerT customerType;
    protected CustomerTierBase customerTier;

    public CustomerBaseClass(){}

    public CustomerBaseClass( String email, String phoneNumber, CustomerT customerType, boolean hasValidLicense, String customerId, int loyaltyPoints ){
        super(email, phoneNumber, UserT.CUSTOMER);
        this.customerId = customerId;
        this.customerType = customerType;
        this.hasValidLicense = hasValidLicense;
        this.loyaltyPoints = loyaltyPoints;
        this.maxAllocations = 1;
        this.customerTier = new CustomerTierBase();
    }

    public CustomerBaseClass(String email, String phoneNumber, CustomerT customerType, boolean hasValidLicense, String customerId) {
        super(email, phoneNumber, UserT.CUSTOMER);
        this.customerId = customerId;
        this.customerType = customerType;
        this.hasValidLicense = hasValidLicense;
        this.loyaltyPoints = 0;
        this.maxAllocations = 1;
        this.customerTier = new CustomerTierBase();
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
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

//    public List<String> getBookings() {
//        bookings = new ArrayList<String>();
//        bookings.add("bookings");
//        return bookings;
//    }

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
        return customerTier;
    }

    public CustomerTierT getCustomerTierType() {
        return customerTier.customerTierType;
    }

    public void setCustomerTier(CustomerTierT type) {
        System.out.println(type);
        switch (type) {
            case CustomerTierT.BRONZE_TIER -> {
                customerTier = new CustomerTierBronze();
            } case CustomerTierT.SILVER_TIER -> {
                customerTier = new CustomerTierSilver();
            } case CustomerTierT.GOLD_TIER -> {
                customerTier = new CustomerTierGold();
            }
            case CustomerTierT.PLATINUM_TIER -> {
                customerTier = new CustomerTierPlatinum();
            }
        }
    }

    public void upgradeCustomerTier(){
        switch (customerTier.getCustomerTierType()) {
            case CustomerTierT.BRONZE_TIER -> {
                customerTier = new CustomerTierSilver();
            } case CustomerTierT.SILVER_TIER -> {
                customerTier = new CustomerTierGold();
            } case CustomerTierT.GOLD_TIER -> {
                customerTier = new CustomerTierPlatinum();
            } case CustomerTierT.PLATINUM_TIER -> System.out.println("DEBUG: Already PLATINUM TIER");
        }

    }

    public void downgradeCustomerTier(){
        switch (customerTier.getCustomerTierType()) {
            case CustomerTierT.BRONZE_TIER -> {
                System.out.println("DEBUG: Already BRONZE TIER");
            }
            case CustomerTierT.SILVER_TIER -> {
                customerTier = new CustomerTierBronze();
            }
            case CustomerTierT.GOLD_TIER -> {
                customerTier = new CustomerTierSilver();
            }
            case CustomerTierT.PLATINUM_TIER -> {
                customerTier = new CustomerTierGold();
            }
        }

    }

    @Override
    public String toString() {
        return "CustomerBaseClass{" +
                "customerId='" + customerId + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                ", maxAllocations=" + maxAllocations +
                ", hasValidLicense=" + hasValidLicense +
                ", customerType=" + customerType +
                ", customerTier=" + customerTier +
                '}';
    }
}
