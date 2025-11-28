package org.example.rental;

import org.example.core.ISingleton;
import org.example.core.RandomKeyGenerator;
import org.example.session.SessionFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class RentalFactory extends AbRentalFactory implements ISingleton {
    private static ISingleton rentalFactoryInstance;
    private long rentalCounter;

    public IRentalOrder createRentalObject(String customerId, String vehicleId, Date rentalDate) {
        (this.rentalCounter)++;
        return new RentalOrder(customerId, vehicleId, rentalDate);
    }

    public static ISingleton getInstance() {
        if ( rentalFactoryInstance == null) {
            rentalFactoryInstance = new RentalFactory();
        }
        return rentalFactoryInstance;
    }

    private String generateUniqueId(String id){
        return "O"+this.rentalCounter;
    }

    private RentalFactory(){
        this.rentalCounter = 12;
        System.out.println("RENTAL FACTORY");
    }

    private String requestVehicleDetails(String vehicleId) {

        return "Vehicle Details";
    }

    private String requestCustomerDetails(String customerId){
        return "Customer Details";
    }




}