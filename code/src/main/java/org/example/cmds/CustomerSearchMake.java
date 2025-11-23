package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.MakeT;
import org.example.vehicle.VehicleMgr;

public class CustomerSearchMake implements Command{



    @Override
    public void execute(SessionWrapper userSession){
        ISingleton sessionMgr = SessionMgr.getInstance();

        if(((SessionMgr)sessionMgr).isValidSession(userSession)){
            ISingleton vehicleMgr = VehicleMgr.getInstance();

        }

    }
}
