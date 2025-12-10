package org.example.rental;

import org.example.core.*;
import org.example.session.SessionFactory;

import java.time.LocalDateTime;
import java.util.Date;

public class RentalFactory extends AbRentalFactory implements ISingleton {
    private static ISingleton rentalFactoryInstance;
    private long rentalCounter;

    private ILogger logger;

    public IRentalOrder createRentalObject(String customerId, String vehicleId, Date rentalDate) {
        (this.rentalCounter)++;
        return new RentalOrder(customerId, vehicleId, rentalDate);
    }

    public IRentalOrder addDiscount(IRentalOrder rentalOrder, DiscountData data) {
        if (data.discountType == DiscountTypeT.DISCOUNT_CODE) {
            logger.debugMessage("Adding a discount: " +  ((Float)data.value) );
            return new DiscountCodeDecorator(rentalOrder, ((Float)data.value) );
        }
        return rentalOrder;
    }


    public IRentalOrder addDiscountCode(IRentalOrder rentalOrder, float discountPercentage){
        return new DiscountCodeDecorator(rentalOrder, discountPercentage);
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
        AbLoggerFactory log = new LoggerFactory();
        this.logger = log.createLogger();
        logger.debugMessage("RENTAL FACTORY");
        this.rentalCounter = 12;

    }



}