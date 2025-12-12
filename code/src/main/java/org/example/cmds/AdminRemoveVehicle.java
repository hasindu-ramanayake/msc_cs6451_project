package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleMgr;

public class AdminRemoveVehicle implements Command{
    private final String vehicleID;

    public AdminRemoveVehicle(String vehicleID){
        this.vehicleID = vehicleID;
    }

    @Override
    public void execute(SessionWrapper userSession){
        if (userSession.isValidSession()){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            ((VehicleMgr) vehicleMgr).removeVehicleFromMap(vehicleID);

        }
    }
}
