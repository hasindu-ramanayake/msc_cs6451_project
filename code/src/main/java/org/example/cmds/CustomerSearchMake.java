package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.MakeT;
import org.example.vehicle.VehicleBaseClass;
import org.example.vehicle.VehicleMgr;

import java.util.List;

public class CustomerSearchMake implements Command{
    MakeT make;

    public CustomerSearchMake(String make){
        this.make = MakeT.getType(make);
    }

    @Override
    public void execute(SessionWrapper userSession){
        ISingleton sessionMgr = SessionMgr.getInstance();
        if( ((SessionMgr)sessionMgr).isValidSession(userSession) ){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            List<VehicleBaseClass> vehicleList = ((VehicleMgr)vehicleMgr).searchVehicleByMake(userSession.session.getUser() ,make);
            if (vehicleList.isEmpty()) {
                System.out.println("No Vehicle find in this make..");
                return;
            }
            for ( VehicleBaseClass vehicle : vehicleList) {
                System.out.println(vehicle);
            }
        }

    }
}
