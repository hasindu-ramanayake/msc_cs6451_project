package org.example.rental;
import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Date;

//Created an Abstract Rental Factory
public abstract class AbRentalFactory {
    //Abstract methods of creating a rental object and generating a unique id
    public abstract IRentalOrder createRentalObject(String customerId, String vehicleId, Date rentalDate);

    //Generate new random ID using UUID
    private String generateUniqueId(){
        String id = UUID.randomUUID().toString();
        return id;

    }
}
