package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleMgr;
import org.example.vehicle.VehicleStateT;

public class StaffReportReady implements Command{
    private final String vehicleID;
    private final VehicleStateT vehicleState;

    public StaffReportReady(String vehicleID, VehicleStateT vehicleState){
        this.vehicleID = vehicleID;
        this.vehicleState = vehicleState;
    }
    @Override
    public void execute(SessionWrapper userSession){
        if (userSession.isValidSession()){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            ((VehicleMgr) vehicleMgr).modifyVehicleState(vehicleID, vehicleState);
        }
    }
}
