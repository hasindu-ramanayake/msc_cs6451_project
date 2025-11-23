package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleMgr;
import org.example.vehicle.VehicleStateT;

public class StaffReportCheckOut implements Command {
    private final String vehicleId;
    private final VehicleStateT vehicleState;

    public StaffReportCheckOut(String vehicleId, VehicleStateT vehicleState){
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
