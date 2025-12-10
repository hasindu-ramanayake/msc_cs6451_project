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

    public static IVehicleGrade createInterface(VehicleGradeT t){
        switch(t){
            case STANDARD: return new GradeStandard();
            case LUXURY: return new GradeLuxury();
            case PREMIUM: return new GradePremium();
            default: return new GradeEconomy();
        }
    }
}
