package org.example.vehicle;

public enum VehicleColorT {
    SILVER, UNKNOWN;

    public static VehicleColorT getType(String t){
        if ( t==null || t.isEmpty() ) return UNKNOWN;
        String normalized = t.trim().toUpperCase();
        for (VehicleColorT color : VehicleColorT.values()) {
            if (color.name().equals(normalized)) {
                return color;
            }
        }
        return UNKNOWN;
    }
}
