package org.example.vehicle;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;

import java.util.Map;

public class VehicleMgr implements ISingleton {

    private Map<String, VehicleBaseClass> vehicleMap;
    private static ISingleton vehicleMgrInst;

    private VehicleMgr() {
    }

    public static ISingleton getInstance() {
        if ( vehicleMgrInst == null) {
            vehicleMgrInst = new VehicleMgr();
        }
        return vehicleMgrInst;
    }

    public void addVehicleToMap(VehicleBaseClass vehicle){}

    public void removeVehicleFromMap(String vehicleID){}

    public void modifyVehicleState(String vehicleID, VehicleStateT state){}

    public void modifyVehicleGrade(String vehicleID, IVehicleGrade grade){}

    public Map<String, VehicleBaseClass> getAllVehicles(){return null;}

    public VehicleBaseClass searchVehicleByMake(MakeT make){return null;}

    public VehicleBaseClass searchVehicleByModel(ModelT model){return null;}

    public VehicleBaseClass getVehicleSpecificObj(String vehicleID){return null;}

    public Map<String, VehicleBaseClass> getAllVehicleByGrade(IVehicleGrade grade){return null;}
}
