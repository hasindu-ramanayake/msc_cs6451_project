package org.example.vehicle;

import org.example.core.ISingleton;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;

import java.util.*;

public class VehicleMgr implements ISingleton {

    private static ISingleton vehicleMgrInst;
    //Database should only be in Manager Classes
    private IDbAdapter db;

    Map<String, VehicleBaseClass> vehicleMap;

    //Singleton Design Pattern
    public static ISingleton getInstance() {
        if ( vehicleMgrInst == null) {
            vehicleMgrInst = new VehicleMgr();
        }
        return vehicleMgrInst;
    }

    private VehicleMgr() {
        //Initialised the Vehicle Map
        db = FileDbAdapter.getInstance();
        this.vehicleMap = new HashMap<>();

        HashMap<String, VehicleBaseClass> adapterMap = ((FileDbAdapter) db).getVehicleMap();
        this.vehicleMap.putAll(adapterMap);

    }


    public void addVehicleToMap(VehicleBaseClass vehicle){
        vehicleMap.put(vehicle.getVehicleID(), vehicle);

        System.out.println("Vehicle added successfully");


    }

    public void removeVehicleFromMap(String vehicleID){
        //Check if the vehicle exists
        if ( vehicleID == null || vehicleID.isEmpty() ){
            System.out.println("Vehicle with "+vehicleID+" does not exist");
        } else {
            VehicleBaseClass vehicle = vehicleMap.get(vehicleID);
            vehicleMap.remove(vehicleID);
            ((FileDbAdapter) db).removeVehicle(vehicle);
            System.out.println("Vehicle removed successfully");
        }

    }

    public void modifyVehicleState(String vehicleID, VehicleStateT state){
        //Gets the vehicle with a specific ID
        VehicleBaseClass vehicle = vehicleMap.get(vehicleID);
        if(vehicle == null){
            System.out.println("Vehicle with ID: "+vehicleID+ " does not exist");
        }
        else{
            System.out.println("Reporting status of "+vehicleID+ " to "+state);
            vehicle.setVehicleState(state);
            ((FileDbAdapter) db).updateVehicleState(vehicle);

        }
    }

    public void modifyVehicleGrade(String vehicleID, IVehicleGrade grade){
        VehicleBaseClass vehicle = vehicleMap.get(vehicleID);
        if(vehicle == null){
            System.out.println("Vehicle with ID: "+vehicleID+ " does not exist");
        }
    }
    //Returns all the vehicles
    public ArrayList<VehicleBaseClass> getAllVehicles(String userId){
        return ((FileDbAdapter)db).getAccessibleVehicalList(userId);
    }

    public List<VehicleBaseClass> searchVehicleByMake(String userId , MakeT make){
        return ((FileDbAdapter)db).getAccessibleVehicalListByMake(userId, make);
    }

    public List<VehicleBaseClass> searchVehicleByDate(String userId , Date date){
        return ((FileDbAdapter)db).getAccessibleVehicalListByDate(userId, date);
    }

    public VehicleBaseClass searchVehicleByModel(ModelT model){
        for(Map.Entry<String, VehicleBaseClass> entry: vehicleMap.entrySet()){
            VehicleBaseClass vehicle = entry.getValue();
            if(model.equals(vehicle.getModel())){
                return vehicle;

            }
        }
        return null;
    }

    //TODO: CHECK THIS FUNCTION
    public VehicleBaseClass getVehicleSpecificObj(String vehicleID){
        return null;
    }

    public VehicleBaseClass getAllVehicleByGrade(IVehicleGrade grade){
        for( Map.Entry<String, VehicleBaseClass> entry: vehicleMap.entrySet() ){
            VehicleBaseClass vehicle = entry.getValue();
            if(grade.equals(vehicle.getVehicleGrade())){
                return vehicle;
            }
        }
        return null;
    }

}
