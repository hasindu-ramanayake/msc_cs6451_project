package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleMgr;
import org.example.vehicle.VehicleStateT;

public class StaffReportOutOfOrder implements Command{
    private final String vehicleID;
    private final VehicleStateT vehicleState;

    public StaffReportOutOfOrder(String vehicleID, VehicleStateT vehicleState){
        this.vehicleID = vehicleID;
        this.vehicleState = vehicleState;
    }
    @Override
    public void execute(SessionWrapper userSession){
        ISingleton sessionMgr = SessionMgr.getInstance();

        if(((SessionMgr) sessionMgr).isValidSession(userSession)){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            ((VehicleMgr) vehicleMgr).modifyVehicleState(vehicleID, vehicleState);
        }
    }
}
