package org.example.db;

import org.example.core.ISingleton;
import org.example.customer.CustomerBaseClass;
import org.example.customer.CustomerT;
import org.example.customer.CustomerTierT;
import org.example.rental.IRentalOrder;
import org.example.rental.RentalOrder;
import org.example.session.ISessionClass;
import org.example.vehicle.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileDbAdapter implements IDbAdapter, ISingleton {
    private static IDbAdapter dbInstance;

    private final FileReaderService fileReader;
    private HashMap<String, VehicleBaseClass> vehicleMap;
    private HashMap<String, CustomerBaseClass> customerMap;
    private HashMap<String, IRentalOrder> rentalMap;
    private HashMap<String, Float> discountMap;

    private static final String VEHICLE_DATA = "src/main/java/org/example/db/VehicleData.csv";
    private static final String ORDER_DATA = "src/main/java/org/example/db/Orders.csv";
    private static final String CUSTOMER_DATA = "src/main/java/org/example/db/Customer.csv";
    private static final String DISCOUNT_DATA = "src/main/java/org/example/db/Discount.csv";

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
        this.rentalMap = new HashMap<>();
        this.discountMap = new HashMap<>();
        readVehicleData(VEHICLE_DATA);
        readRentalData(ORDER_DATA);
        readCustomerData(CUSTOMER_DATA);
        readDiscountData(DISCOUNT_DATA);
        printMap();
    }

    public Map<String, VehicleBaseClass> getVehicleMap() {
        return vehicleMap;
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

    @Override
    public void readDiscountData(String source)  {
        this.processDiscountData(fileReader.loadFromFile(source));
    }

    private void processVehicleData(List<String[]> data){
        for( var d: data ) {
            IVehicleGrade vG = new GradeEconomy();
            switch (VehicleGradeT.getType(d[1])) {
                case VehicleGradeT.ECONOMY ->  { vG= new GradeEconomy(); }
                case VehicleGradeT.STANDARD -> { vG = new GradeStandard();}
                case VehicleGradeT.LUXURY -> { vG = new GradeLuxury(); }
                case VehicleGradeT.PREMIUM -> { vG = new GradePremium();  }// need to premium
                case VehicleGradeT.UNKNOWN -> { vG = new GradeEconomy();  } // need new CLass for unknown
            }

            VehicleBaseClass ve = new VehicleBaseClass( d[0] //vehicleId
                    ,vG//grade
                    ,VehicleStateT.getType(d[2]) //state
                    ,Integer.parseInt(d[3]) //Pcount
                    ,MakeT.getType(d[4]) //Make
                    ,ModelT.getType(d[5]) //Model
                    ,VehicleColorT.getType(d[6]) //color
                    ); //rental rate
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
                throw new IllegalArgumentException("Invalid date format: " + d[3], e);
            }
            IRentalOrder rO = new RentalOrder( d[0] // orderID
                    ,d[1] // customerID
                    ,d[2] // vehicleID,
                    ,orderDate // date
                    ,Float.parseFloat(d[4]) // fee
                    ,Integer.parseInt(d[5])// loyalityPoints
                    ,Boolean.parseBoolean(d[6]) // isPaid
            );
            this.rentalMap.put(d[0],rO);
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

    private void processDiscountData(List<String[]> data){
        for (var d: data ) {
            String name = d[0];
            float percentage = Float.parseFloat(d[1]);
            this.discountMap.put(name, percentage);
        }
    }

    @Override public boolean isValidCustomer(String userId) {
        return customerMap.containsKey(userId);
    }

    @Override public boolean isValidVehicle(String vehicleId) {
        return vehicleMap.containsKey(vehicleId);
    }

    @Override public void addCustomer(CustomerBaseClass cu) {
        System.out.println("Adding Customer: "+ cu);
        customerMap.put(cu.getCustomerId(), cu);
    }

    @Override public boolean isAccessibleVehical(String customerId, String vehicleId) {
        for (VehicleGradeT allowedGrade : customerMap.get(customerId).getCustomerTier().getVehicleGradeType()) {
            if ( vehicleMap.get(vehicleId).getVehicleGrade().getGrade() == allowedGrade ) {
                return true;
            }
        }
        return false;
    }

    @Override public boolean isAvailableVehical(String vehicleId, Date orderDate) {
        for (IRentalOrder order : rentalMap.values()) {
            if (order.getVehicleId().equals(vehicleId) && order.getRentalDate().equals(orderDate)) {
                return false; // Already booked
            }
        }
        return true;
    }

    @Override public CustomerBaseClass getCustomer(String customerId) {
        CustomerBaseClass cu = customerMap.get(customerId);
        System.out.println(cu);
        return cu;
    }

    @Override public List<VehicleBaseClass> getAccessibleVehicalList(String userId) {
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

    @Override  public List<VehicleBaseClass> getAccessibleVehicalListByMake(String userId, MakeT make) {
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
    @Override
    public VehicleBaseClass getSpecificVehicle(String vehicleID){
        return vehicleMap.get(vehicleID);
    }

    // need a better algorithm or new Bd table for easy filtering
    @Override
    public List<VehicleBaseClass> getAccessibleVehicalListByDate(String userId, Date date) {
        ArrayList<VehicleBaseClass> list = new ArrayList<>();
        var accessibleVehicles = getAccessibleVehicalList(userId);

        for (VehicleBaseClass vehicle : accessibleVehicles) {
            boolean isRentedOnDate = false;

            for (var entry : this.rentalMap.entrySet()) {
                var rental = entry.getValue();
                if (rental.getVehicleId().equals(vehicle.getVehicleID()) &&
                        rental.getRentalDate().equals(date)) {
                    isRentedOnDate = true;
                    break; // No need to check further rentals for this vehicle
                }
            }

            if (!isRentedOnDate) {
                list.add(vehicle);
            }
        }

        return list;
    }


    @Override public ArrayList<IRentalOrder> getRentalOrdersForCustomer(String userId) {
        ArrayList<IRentalOrder> orders = new ArrayList<>();
        for (IRentalOrder order : rentalMap.values()) {
            if (order.getCustomerId().equals(userId)) {
                orders.add(order);
            }
        }
        return orders;
    }

    @Override public IRentalOrder getRentalOrderFromID(String orderID){
        IRentalOrder rentalOrder = this.rentalMap.get(orderID);

        if (rentalOrder == null) {
            throw new IllegalArgumentException("No rental order found for ID: " + orderID);
        }

        return rentalOrder;
    }

    @Override public void addRentalOrder(IRentalOrder rentalOrder) {
//        rentalOrder.setFee( vehicleMap.get(rentalOrder.getVehicleId()).getRentalRate().getRate() );
        System.out.println(rentalOrder);
        rentalMap.put(rentalOrder.getOrderId(), rentalOrder);
    }

    @Override
    public void removeVehicle(VehicleBaseClass vehicle){
        vehicleMap.remove(vehicle.getVehicleID(), vehicle);
        writeVehicleDataToFile(VEHICLE_DATA);

    }
    @Override
    public void addVehicle(VehicleBaseClass vehicle){
        vehicleMap.put(vehicle.getVehicleID(), vehicle);
        writeVehicleDataToFile(VEHICLE_DATA);
    }


    private void writeVehicleDataToFile(String filePath) {
        try (PrintWriter pw = new PrintWriter(new File(filePath))) {
            pw.println("vehicleID,vehicleGrade,vehicleState,passengerCount,make,model,color");

            vehicleMap.values().stream()
                    .sorted((v1, v2) -> {
                        int id1 = Integer.parseInt(v1.getVehicleID().substring(1));
                        int id2 = Integer.parseInt(v2.getVehicleID().substring(1));
                        return Integer.compare(id1, id2);
                    })
                    .forEach(vehicle -> pw.println(String.join(",",
                            vehicle.getVehicleID(),
                            vehicle.getVehicleGrade().getGrade().name(),
                            vehicle.getVehicleState().name(),
                            String.valueOf(vehicle.getPassengerCount()),
                            vehicle.getMake().toString(),
                            vehicle.getModel().toString(),
                            vehicle.getColor().toString()
                    )));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public float getDiscountPercentage(String discountName){
        for (Map.Entry<String, Float> entry : discountMap.entrySet()) {
            String name = entry.getKey();
            float percentage = entry.getValue();
            if (name.equals(discountName)) {
                return percentage;
            }
        }
        return 0;
    }


    private void printMap(){
        for (var cu: customerMap.entrySet() ) {
            System.out.println(cu.getValue());
        }
    }

}
