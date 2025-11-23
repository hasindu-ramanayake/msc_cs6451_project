package org.example.vehicle;

public class GradePremium implements IVehicleGrade{
    @Override
    public VehicleGradeT getGrade(){
        return VehicleGradeT.PREMIUM;
    }
}
