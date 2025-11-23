package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleBaseClass;
import org.example.vehicle.VehicleMgr;

import java.util.HashMap;

public class CustomerSearchAll implements Command{

    public CustomerSearchAll(){

    }

    @Override
    public void execute(SessionWrapper userSession){
        System.out.println("Getting all Vehicles");
        ISingleton sessionMgr = SessionMgr.getInstance();

        if(((SessionMgr) sessionMgr).isValidSession(userSession)){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            HashMap<String, VehicleBaseClass> vehicleMap = ((VehicleMgr) vehicleMgr).getAllVehicles();
            ((VehicleMgr)vehicleMgr).printAllVehicles(vehicleMap);

        }

    }
}
