package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleBaseClass;
import org.example.vehicle.VehicleMgr;

import java.util.List;

public class CustomerSearchAll implements Command{

    public CustomerSearchAll(){

    }

    @Override
    public void execute(SessionWrapper userSession){
        if (userSession.isValidSession()){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            List<VehicleBaseClass> vehiclesList = ((VehicleMgr) vehicleMgr).getAllVehicles(userSession.session.getUser());
            for (VehicleBaseClass v: vehiclesList ) {
                System.out.println(v);
            }

        }

    }
}
