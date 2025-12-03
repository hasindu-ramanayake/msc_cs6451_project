package org.example.customer;

public enum CustomerTierT {
    BRONZE_TIER, SILVER_TIER, GOLD_TIER, PLATINUM_TIER,;

    public static CustomerTierT getType(String t){
        if ( t==null || t.isEmpty() ) return BRONZE_TIER;
        String normalized = t.trim().toUpperCase();
        for (CustomerTierT tierT : CustomerTierT.values()) {
            if (tierT.name().equals(normalized)) {
                return tierT;
            }
        }
        return BRONZE_TIER;
    }
}
