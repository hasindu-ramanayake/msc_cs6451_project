package org.example.vehicle;

public enum VehicleGradeT {
    ECONOMY, STANDARD, LUXURY, PREMIUM, UNKNOWN;

    public static VehicleGradeT getType(String t){
        if ( t==null || t.isEmpty() ) return UNKNOWN;
        String normalized = t.trim().toUpperCase();
        for (VehicleGradeT grade : VehicleGradeT.values()) {
            if (grade.name().equals(normalized)) {
                return grade;
            }
        }
        return UNKNOWN;
    }
}
