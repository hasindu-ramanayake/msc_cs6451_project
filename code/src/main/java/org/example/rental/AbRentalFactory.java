package org.example.rental;
import org.example.core.RandomKeyGenerator;
import java.util.Date;

//Created an Abstract Rental Factory
public abstract class AbRentalFactory {
    //Abstract methods of creating a rental object and generating a unique id
    public abstract IRentalOrder createRentalObject(String customerId, String vehicleId, Date rentalDate);

    //Generate new random ID using UUID
    protected String generateUniqueId() {
        return RandomKeyGenerator.generateRandomKey();
    }
}
