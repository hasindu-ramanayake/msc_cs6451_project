package org.example.vehicle;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.ISingleton;
import org.example.core.LoggerFactory;
import org.example.db.FileDbAdapter;
import org.example.db.IDbAdapter;

import java.util.*;

public class VehicleMgr implements ISingleton {

    private static ISingleton vehicleMgrInst;
    //Database should only be in Manager Classes
    private final IDbAdapter db;

    private final ILogger logger;


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

//        Map<String, VehicleBaseClass> adapterMap = db.getVehicleMap();

        AbLoggerFactory log = new LoggerFactory();
        this.logger = log.createLogger();

    }


    public void addVehicleToMap(VehicleBaseClass vehicle){
        VehicleBaseClass existingVehicle = getVehicleByID(vehicle.vehicleID);
        if(existingVehicle != null){
            logger.normalMessage("Vehicle Already Exists");
        }
        else{
            db.addVehicle(vehicle);
            logger.normalMessage("Vehicle added successfully");
        }
    }

    public void removeVehicleFromMap(String vehicleID){
        //Check if the vehicle exists
        VehicleBaseClass vehicle = getVehicleByID(vehicleID);
        if ( vehicle == null){
            logger.normalMessage("Vehicle with "+vehicleID+" does not exist");
        } else {
//            vehicleMap.remove(vehicleID);
            db.removeVehicle(vehicle);
            logger.normalMessage("Vehicle removed successfully");
        }

    }

    public void modifyVehicleState(String vehicleID, VehicleStateT state){
        //Gets the vehicle with a specific ID
        VehicleBaseClass vehicle = getVehicleByID(vehicleID);
        if(vehicle == null){
            logger.normalMessage("Vehicle with ID: "+vehicleID+ " does not exist");
        }
        else{
            logger.normalMessage("Reporting status of "+vehicleID+ " to "+state);
            vehicle.setVehicleState(state);
            db.addVehicle(vehicle);
        }
    }

    public void modifyVehicleGrade(String vehicleID, IVehicleGrade grade){
        VehicleBaseClass vehicle = getVehicleByID(vehicleID);
        if(vehicle == null){
            logger.normalMessage("Vehicle with ID: "+vehicleID+ " does not exist");
        }
        else{
            logger.normalMessage("Changing Vehicle Grade to "+grade);
            vehicle.setVehicleGrade(grade);
            db.addVehicle(vehicle);
        }
    }
    //Returns all the vehicles
    public List<VehicleBaseClass> getAllVehicles(String userId){
        return db.getAccessibleVehicalList(userId);
    }

    public List<VehicleBaseClass> searchVehicleByMake(String userId , MakeT make){
        return db.getAccessibleVehicalListByMake(userId, make);
    }

    public List<VehicleBaseClass> searchVehicleByDate(String userId , Date date){
        return db.getAccessibleVehicalListByDate(userId, date);
    }

    public VehicleBaseClass getVehicleByID(String vehicleID){
        return db.getSpecificVehicle(vehicleID);
    }

//    public VehicleBaseClass searchVehicleByModel(ModelT model){
//        for(Map.Entry<String, VehicleBaseClass> entry: vehicleMap.entrySet()){
//            VehicleBaseClass vehicle = entry.getValue();
//            if(model.equals(vehicle.getModel())){
//                return vehicle;
//
//            }
//        }
//        return null;
//    }

//    public VehicleBaseClass getVehicleSpecificObj(String vehicleID){
//        return null;
//    }

//    public VehicleBaseClass getAllVehicleByGrade(IVehicleGrade grade){
//        for( Map.Entry<String, VehicleBaseClass> entry: vehicleMap.entrySet() ){
//            VehicleBaseClass vehicle = entry.getValue();
//            if(grade.equals(vehicle.getVehicleGrade())){
//                return vehicle;
//            }
//        }
//        return null;
//    }

}