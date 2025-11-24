package org.example.vehicle;

public enum MakeT {
    SEAT, BMW, TOYOTA, UNKNOWN;

    public static MakeT getType(String t){
        if ( t==null || t.isEmpty() ) return UNKNOWN;
        String normalized = t.trim().toUpperCase();
        for (MakeT make : MakeT.values()) {
            if (make.name().equals(normalized)) {
                return make;
            }
        }
        return UNKNOWN;
    }
}
