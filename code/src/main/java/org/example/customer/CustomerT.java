package org.example.customer;

public enum CustomerT {
    PERSONAL_CUSTOMER, BUSINESS_CUSTOMER;

    public static CustomerT getType(String t){
        if ( t==null || t.isEmpty() ) return PERSONAL_CUSTOMER;
        String normalized = t.trim().toUpperCase();
        for (CustomerT cuT : CustomerT.values()) {
            if (cuT.name().equals(normalized)) {
                return cuT;
            }
        }
        return PERSONAL_CUSTOMER;
    }
}
