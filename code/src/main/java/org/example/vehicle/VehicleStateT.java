package org.example.vehicle;

public enum VehicleStateT {
    READY, CHECK_IN, CHECK_OUT, OUT_OF_ORDER;

    public static VehicleStateT getType(String t){
        if ( t==null || t.isEmpty() ) return OUT_OF_ORDER;
        String normalized = t.trim().toUpperCase();
        for (VehicleStateT state : VehicleStateT.values()) {
            if (state.name().equals(normalized)) {
                return state;
            }
        }
        return OUT_OF_ORDER;
    }
}
