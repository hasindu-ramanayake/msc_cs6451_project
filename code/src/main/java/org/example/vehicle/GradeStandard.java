package org.example.vehicle;

public class GradeStandard implements IVehicleGrade{

    @Override
    public VehicleGradeT getGrade(){
        return VehicleGradeT.STANDARD;
    }
}
