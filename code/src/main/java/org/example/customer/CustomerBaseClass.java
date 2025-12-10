package org.example.customer;

public class CustomerBaseClass extends UserClass{
    protected String customerId;
    protected int loyaltyPoints;
    protected int maxAllocations;
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
        return this.loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getMaxAllocations() {
        return this.maxAllocations;
    }

    public void setMaxAllocations(int maxAllocations) {
        this.maxAllocations = maxAllocations;
    }

    public boolean isHasValidLicense() {
        return this.hasValidLicense;
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
            case CustomerTierT.BRONZE_TIER : {
                customerTier = new CustomerTierBronze();
                break;
            } case CustomerTierT.SILVER_TIER : {
                customerTier = new CustomerTierSilver();
                break;
            } case CustomerTierT.GOLD_TIER : {
                customerTier = new CustomerTierGold();
                break;
            }
            case CustomerTierT.PLATINUM_TIER : {
                customerTier = new CustomerTierPlatinum();
                break;
            }
            default: assert(true);
        }
    }

    public void upgradeCustomerTier(){
        switch (customerTier.getCustomerTierType()) {
            case CustomerTierT.BASE_TIER : {
                customerTier = new CustomerTierBronze();
                break;
            } case CustomerTierT.BRONZE_TIER : {
                customerTier = new CustomerTierSilver();
                break;
            } case CustomerTierT.SILVER_TIER : {
                customerTier = new CustomerTierGold();
                break;
            } case CustomerTierT.GOLD_TIER : {
                customerTier = new CustomerTierPlatinum();
                break;
            } case CustomerTierT.PLATINUM_TIER : {
                System.out.println("DEBUG: Already PLATINUM TIER");
                break;
            }
            default: assert(true);
        }

    }

    public void downgradeCustomerTier(){
        switch (customerTier.getCustomerTierType()) {
            case CustomerTierT.BASE_TIER : {
                System.out.println("DEBUG: Already BASE TIER");
                break;
            }
            case CustomerTierT.BRONZE_TIER : {
                customerTier = new CustomerTierBase();
                break;
            }
            case CustomerTierT.SILVER_TIER : {
                customerTier = new CustomerTierBronze();
                break;
            }
            case CustomerTierT.GOLD_TIER : {
                customerTier = new CustomerTierSilver();
                break;
            }
            case CustomerTierT.PLATINUM_TIER : {
                customerTier = new CustomerTierGold();
                break;
            }
            default: assert(true);
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
