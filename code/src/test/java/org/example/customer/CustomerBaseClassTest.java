package org.example.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerBaseClassTest {

    private CustomerBaseClass customer;

    @BeforeEach
    void setUp() {
        customer = new CustomerBaseClass(
                "mail@test.com",
                "01020304",
                CustomerT.PERSONAL_CUSTOMER,
                true,
                "CID123",
                50
        );
    }

    @Test
    void testConstructorWithLoyaltyPoints() {
        assertEquals("CID123", customer.getCustomerId());
        assertEquals(CustomerT.PERSONAL_CUSTOMER, customer.getCustomerType());
        assertTrue(customer.isHasValidLicense());
        assertEquals(50, customer.getLoyaltyPoints());
        assertEquals(1, customer.getMaxAllocations());
    }

    @Test
    void testConstructorWithoutLoyaltyPoints() {
        CustomerBaseClass customer2 = new CustomerBaseClass(
                "mail2@test.com",
                "0999888",
                CustomerT.BUSINESS_CUSTOMER,
                false,
                "CID777"
        );

        assertEquals("CID777", customer2.getCustomerId());
        assertEquals(CustomerT.BUSINESS_CUSTOMER, customer2.getCustomerType());
        assertFalse(customer2.hasValidLicense);
        assertEquals(0, customer2.getLoyaltyPoints());
        assertEquals(1, customer2.getMaxAllocations());
    }

    @Test
    void testSetLoyaltyPoints() {
        customer.setLoyaltyPoints(200);
        assertEquals(200, customer.getLoyaltyPoints());
    }

    @Test
    void testSetMaxAllocations() {
        customer.setMaxAllocations(5);
        assertEquals(5, customer.getMaxAllocations());
    }

    @Test
    void testLicenseSetterAndGetter() {
        customer.setHasValidLicense(false);
        assertFalse(customer.isHasValidLicense());
    }

    @Test
    void testCustomerTypeSetter() {
        customer.setCustomerType(CustomerT.BUSINESS_CUSTOMER);
        assertEquals(CustomerT.BUSINESS_CUSTOMER, customer.getCustomerType());
    }

    @Test
    void testSetCustomerTier() {
        customer.setCustomerTier(CustomerTierT.SILVER_TIER);
        assertEquals(CustomerTierT.SILVER_TIER, customer.getCustomerTierType());
    }

    @Test
    void testUpgradeCustomerTier() {
        customer.setCustomerTier(CustomerTierT.BASE_TIER);

        customer.upgradeCustomerTier();
        assertEquals(CustomerTierT.BRONZE_TIER, customer.getCustomerTierType());

        customer.upgradeCustomerTier();
        assertEquals(CustomerTierT.SILVER_TIER, customer.getCustomerTierType());

        customer.upgradeCustomerTier();
        assertEquals(CustomerTierT.GOLD_TIER, customer.getCustomerTierType());
    }

    @Test
    void testDowngradeCustomerTier() {
        customer.setCustomerTier(CustomerTierT.GOLD_TIER);

        customer.downgradeCustomerTier();
        assertEquals(CustomerTierT.SILVER_TIER, customer.getCustomerTierType());

        customer.downgradeCustomerTier();
        assertEquals(CustomerTierT.BRONZE_TIER, customer.getCustomerTierType());

        customer.downgradeCustomerTier();
        assertEquals(CustomerTierT.BASE_TIER, customer.getCustomerTierType());
    }

    @Test
    void testToStringContainsValues() {
        String result = customer.toString();

        assertTrue(result.contains("customerId='CID123'"));
        assertTrue(result.contains("customerType="));
        assertTrue(result.contains("customerTier="));
    }
}
