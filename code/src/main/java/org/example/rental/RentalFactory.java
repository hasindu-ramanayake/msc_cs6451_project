package org.example.rental;

import org.example.core.ISingleton;
import org.example.session.SessionFactory;

import java.time.LocalDateTime;

public class RentalFactory extends AbRentalFactory implements ISingleton {
    private static ISingleton rentalFactoryInstance;

    public IRentalOrder createRentalObject(String customerId, String vehicleId, LocalDateTime rentalDate) {
        return new RentalOrder();
    }

    public static ISingleton getInstance() {
        if ( rentalFactoryInstance == null) {
            rentalFactoryInstance = new RentalFactory();
        }
        return rentalFactoryInstance;
    }

    private String generateUniqueId(String id){
        return id;
    }

    private RentalFactory(){
        System.out.println("RENTAL FACTORY");
    }

    private String requestVehicleDetails(String vehicleId) {
        return "Vehicle Details";
    }

    private String requestCustomerDetails(String customerId){
        return "Customer Details";
    }




}