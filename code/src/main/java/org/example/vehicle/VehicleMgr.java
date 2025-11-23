package org.example.vehicle;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VehicleMgr implements ISingleton {

    private final HashMap<String, VehicleBaseClass> vehicleMap;
    private static ISingleton vehicleMgrInst;

    //Singleton Design Pattern
    public static ISingleton getInstance() {
        if ( vehicleMgrInst == null) {
            vehicleMgrInst = new VehicleMgr();
        }
        return vehicleMgrInst;
    }

    private VehicleMgr() {
        //Initialise 20 dummy vehicles
        vehicleMap = new HashMap<>();
        for(int i = 0; i<20; i++){
            VehicleBaseClass vehicle = new VehicleBaseClass(Integer.toString(i), new GradeStandard(), VehicleStateT.READY,5, MakeT.SEAT, ModelT.IBIZA , VehicleColorT.SILVER, new RentalRateStandard());

            vehicleMap.put(vehicle.getVehicleID(), vehicle );
        }
    }


    public void addVehicleToMap(VehicleBaseClass vehicle){
        vehicleMap.put(vehicle.getVehicleID(), vehicle);
        System.out.println("Vehicle added successfully");

    }

    public void removeVehicleFromMap(String vehicleID){
        //Check if the vehicle exists
        if(vehicleID == null){
            System.out.println("This vehicle does not exist");
        }
        else{
            vehicleMap.remove(vehicleID);
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
        }
    }

    public void modifyVehicleGrade(String vehicleID, IVehicleGrade grade){
        VehicleBaseClass vehicle = vehicleMap.get(vehicleID);
        if(vehicle == null){
            System.out.println("Vehicle with ID: "+vehicleID+ " does not exist");
        }

    }
    //Returns all the vehicles
    public HashMap<String, VehicleBaseClass> getAllVehicles(){
        return vehicleMap;
    }

    public void printAllVehicles(HashMap<String, VehicleBaseClass> allVehicles){
        for(var entry: allVehicles.entrySet()){
            VehicleBaseClass vehicle = entry.getValue();
            System.out.println("ID: "+vehicle.getVehicleID());
            System.out.println("Vehicle Grade: "+vehicle.getVehicleGrade());
            System.out.println("Vehicle State: "+vehicle.getVehicleState());
            System.out.println("Passenger Count: "+vehicle.getPassengerCount());
            System.out.println("Make: "+vehicle.getMake());
            System.out.println("Model: "+vehicle.getModel());
            System.out.println("Rental Rate: "+vehicle.getRentalRate());
            System.out.println("-------------------");
        }
    }


    public VehicleBaseClass searchVehicleByMake(MakeT make){
        for(Map.Entry<String, VehicleBaseClass> entry: vehicleMap.entrySet()){
            VehicleBaseClass vehicle = entry.getValue();
            if(make.equals(vehicle.getMake())){
                return vehicle;
            }
        }
        return null;
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

//| Todo: Check what this actually does
    public VehicleBaseClass getVehicleSpecificObj(String vehicleID){
        return null;
    }

    public VehicleBaseClass getAllVehicleByGrade(IVehicleGrade grade){
        for(Map.Entry<String, VehicleBaseClass> entry: vehicleMap.entrySet()){
            VehicleBaseClass vehicle = entry.getValue();
            if(grade.equals(vehicle.getVehicleGrade())){
                return vehicle;
            }
        }
        return null;
    }
}
