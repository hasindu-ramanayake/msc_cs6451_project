package org.example.customer;

import org.example.vehicle.ModelT;

public enum CustomerTierT {
    BASE_TIER, BRONZE_TIER, SILVER_TIER, GOLD_TIER;

    public static CustomerTierT getType(String t){
        if ( t==null || t.isEmpty() ) return BASE_TIER;
        String normalized = t.trim().toUpperCase();
        for (CustomerTierT tierT : CustomerTierT.values()) {
            if (tierT.name().equals(normalized)) {
                return tierT;
            }
        }
        return BASE_TIER;
    }
}
