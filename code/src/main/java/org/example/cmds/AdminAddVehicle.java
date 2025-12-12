package org.example.cmds;
import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.*;

public class AdminAddVehicle implements Command {
    private String vehicleID;
    private IVehicleGrade vehicleGrade;
    private int passengerCount;
    private MakeT make;
    private ModelT model;
    private VehicleColorT color;

    public AdminAddVehicle(String vehicleID, IVehicleGrade vehicleGrade, int passengerCount, MakeT make, ModelT model, VehicleColorT color){
        this.vehicleID = vehicleID;
        this.vehicleGrade = vehicleGrade;
        this.passengerCount = passengerCount;
        this.make = make;
        this.model = model;
        this.color = color;
    }


    @Override
    public void execute(SessionWrapper userWrapper){
        if (userWrapper.isValidSession()){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            VehicleBaseClass newVehicle = new VehicleBaseClass(vehicleID, vehicleGrade, VehicleStateT.CHECK_IN, passengerCount, make, model, color);
            ((VehicleMgr) vehicleMgr).addVehicleToMap(newVehicle);
        }
    }
}
