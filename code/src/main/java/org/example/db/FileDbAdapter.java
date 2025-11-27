package org.example.db;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;
import org.example.customer.CustomerT;
import org.example.customer.CustomerTierT;
import org.example.rental.IRentalOrder;
import org.example.rental.RentalOrder;
import org.example.session.ISessionClass;
import org.example.vehicle.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class FileDbAdapter implements IDbAdapter, ISingleton {
    private static IDbAdapter dbInstance;


    private final FileReaderService fileReader;
    private HashMap<String, VehicleBaseClass> vehicleMap;
    private HashMap<String, CustomerBaseClass> customerMap;
    private HashMap<String, IRentalOrder> RentalMap;

    public static IDbAdapter getInstance() {
        if (dbInstance == null) {
            dbInstance = new FileDbAdapter();
        }
        return dbInstance;
    }

    private FileDbAdapter() {
        this.fileReader = new FileReaderService();
        this.vehicleMap = new HashMap<>();
        this.customerMap = new HashMap<>();
        this.RentalMap = new HashMap<>();
        readVehicleData("src/main/java/org/example/db/VehicleData.csv");
        readRentalData("src/main/java/org/example/db/Orders.csv");
        readCustomerData("src/main/java/org/example/db/Customer.csv");
        printMap();
    }

    @Override
    public void readVehicleData(String source) {
        this.processVehicleData( fileReader.loadFromFile(source) );
    }
    @Override
    public void readCustomerData(String source) {
        this.processCustomerData(fileReader.loadFromFile(source));
    }

    @Override
    public void readRentalData(String source) {
        this.processRentalData(fileReader.loadFromFile(source));
    }

    private void processVehicleData(List<String[]> data){
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

            VehicleBaseClass ve = new VehicleBaseClass( d[0] //vehicleId
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

    private void processRentalData( List<String[]> data ) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for( var d: data ) {
            Date orderDate = new Date();
            try {
                orderDate = formatter.parse(d[3]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            IRentalOrder rO = new RentalOrder( d[0] // orderID
                    ,d[1] // customerID
                    ,d[2] // vehicleID,
                    ,orderDate // date
                    ,Float.parseFloat(d[4]) // fee
                    ,Boolean.parseBoolean(d[5]) // isPaid
            );
            this.RentalMap.put(d[0],rO);
        }

    }

    private void processCustomerData(List<String[]> data) {
        for (var d: data ) {
            CustomerBaseClass cu = new CustomerBaseClass(d[0] // email
                    ,d[1] // phone number
                    ,CustomerT.getType(d[2]) // customerT
                    ,Boolean.parseBoolean(d[3]) //isValidDrivingLic
                    ,d[4] //customer id
                    ,Integer.parseInt(d[5]) //loyalty points
            );
            cu.setCustomerTier(CustomerTierT.getType(d[6]));
            this.customerMap.put(d[4], cu);
        }
    }

    @Override public boolean isValidCustomer(String userId) {
//        printMap();
        return customerMap.containsKey(userId);
    }

    @Override public void addCustomer(CustomerBaseClass cu) {
        System.out.println("Adding Customer: "+ cu);
        customerMap.put(cu.getCustomerId(), cu);
    }

    @Override public CustomerBaseClass getCustomer(String customerId) {
        CustomerBaseClass cu = customerMap.get(customerId);
        System.out.println(cu);
        return cu;
    }

    @Override public ArrayList<VehicleBaseClass> getAccessibleVehicalList(String userId) {
        // assume this will return valid customer
        ArrayList<VehicleBaseClass> list = new ArrayList<>();
        CustomerBaseClass cu = customerMap.get(userId);
        for (VehicleGradeT ty: cu.getCustomerTier().getVehicleGradeType() ) {
            for ( var v: vehicleMap.entrySet() ) {
                if (v.getValue().getVehicleGrade().getGrade() == ty ) {
                    list.add(v.getValue());
                }
            }
        }
        return  list;
    }

    @Override  public ArrayList<VehicleBaseClass> getAccessibleVehicalListByMake(String userId, MakeT make) {
        // assume this will return valid customer
        ArrayList<VehicleBaseClass> list = new ArrayList<>();
        CustomerBaseClass cu = customerMap.get(userId);
        for (VehicleGradeT ty: cu.getCustomerTier().getVehicleGradeType() ) {
            for ( var v: vehicleMap.entrySet() ) {
                if (v.getValue().getVehicleGrade().getGrade() == ty && v.getValue().getMake() == make) {
                    list.add(v.getValue());
                }
            }
        }
        return  list;
    }

    private void printMap(){
        for (var cu: vehicleMap.entrySet() ) {
            System.out.println(cu.getValue());
        }
    }

}
