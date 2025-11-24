package org.example.db;

import org.example.customer.CustomerBaseClass;
import org.example.rental.IRentalOrder;
import org.example.vehicle.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FileDbAdapter implements IDbAdapter {
    private final FileReaderService fileReader;
    private HashMap<String, VehicleBaseClass> vehicleMap;
    private HashMap<String, CustomerBaseClass> customerMap;
    private HashMap<String, IRentalOrder> RentalMap;

    public FileDbAdapter() {
        this.fileReader = new FileReaderService();
        this.vehicleMap = new HashMap<>();
        this.customerMap = new HashMap<>();
        this.RentalMap = new HashMap<>();
    }

    @Override
    public void readVehicleData(String source) {
        this.processVehicleData( fileReader.loadFromFile(source) );
    }
    @Override
    public void readCustomerData(String source) {
        fileReader.loadFromFile(source);
    }

    @Override
    public void readRentalData(String source) {
        fileReader.loadFromFile(source);
    }

    public void processVehicleData(List<String[]> data){
        for( var d: data ) {
            IVehicleGrade vG = new GradeEconomy();
            AbRentalRateBaseClass rr = new RentalRateEconomy();
            switch (VehicleGradeT.getType(d[1])) {
                case VehicleGradeT.ECONOMY ->  { vG= new GradeEconomy(); rr= new RentalRateEconomy(); }
                case VehicleGradeT.STANDARD -> { vG = new GradeStandard(); rr = new RentalRateStandard(); }
                case VehicleGradeT.LUXURY -> { vG = new GradeLuxury(); rr = new RentalRateLuxury(); }
                case VehicleGradeT.PREMIUM -> { vG = new GradePremium(); rr = new RentalRateLuxury(); }// need to premium
                case VehicleGradeT.UNKNOWN -> { vG = new GradeEconomy(); rr = new RentalRateEconomy(); } // need new CLass for unknown
            }

            VehicleBaseClass ve = new VehicleBaseClass(
                    d[0] //vehicleId
                    ,vG//grade
                    ,VehicleStateT.getType(d[2]) //state
                    ,Integer.parseInt(d[3]) //Pcount
                    ,MakeT.getType(d[4]) //Make
                    ,ModelT.getType(d[5]) //Model
                    ,VehicleColorT.getType(d[6]) //color
                    ,rr ); //rental rate

            this.vehicleMap.put(d[0], ve);
        }

    }

}
