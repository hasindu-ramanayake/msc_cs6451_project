package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleStateT;
import org.example.vehicle.VehicleMgr;

public class StaffReportCheckIn implements Command {
    private final String vehicleId;
    private final VehicleStateT vehicleState;

    public StaffReportCheckIn(String vehicleId, VehicleStateT vehicleState){
        this.vehicleId = vehicleId;
        this.vehicleState = vehicleState;
    }

    @Override
    public void execute(SessionWrapper userSession){
        ISingleton sessionMgr = SessionMgr.getInstance();

        if(((SessionMgr) sessionMgr).isValidSession(userSession)){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            ((VehicleMgr) vehicleMgr).modifyVehicleState(vehicleId, vehicleState);
        }


    }
}
