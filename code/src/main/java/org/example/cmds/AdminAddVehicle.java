package org.example.cmds;
import org.example.core.ISingleton;
import org.example.customer.StaffT;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleBaseClass;
import org.example.vehicle.VehicleMgr;

public class AdminAddVehicle implements Command {




    @Override
    public void execute(SessionWrapper userWrapper){
        ISingleton sessionMgr = SessionMgr.getInstance();

        if(((SessionMgr) sessionMgr).isValidSession(userWrapper)){
            ISingleton vehicleMgr = VehicleMgr.getInstance();

        }



    }

}
