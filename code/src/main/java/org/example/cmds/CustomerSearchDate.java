package org.example.cmds;

import org.example.core.ISingleton;
import org.example.session.SessionMgr;
import org.example.session.SessionWrapper;
import org.example.vehicle.VehicleBaseClass;
import org.example.vehicle.VehicleMgr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerSearchDate implements Command{
    Date orderDate;

    public CustomerSearchDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.orderDate = formatter.parse(date);
        } catch (ParseException e) {
            System.out.println("Issue in date format: dd/MM/yyyy");
            return;
        }
    }

    @Override
    public void execute(SessionWrapper userSession){
        if (userSession.isValidSession()){
            ISingleton vehicleMgr = VehicleMgr.getInstance();
            List<VehicleBaseClass> vehicleList = ((VehicleMgr)vehicleMgr).searchVehicleByDate(userSession.session.getUser() ,orderDate);
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
