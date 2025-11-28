package org.example.rental;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public interface IRentalOrder {

    public String getOrderId();
    public String getCustomerId();

    public String generateId();

    public Date getRentalDate();
    public String getVehicleId();
    public float getFee();
    public boolean getIsPaid();
    public String printRentalOrder();

    public void setCustomerId(String customerId);
    public void setRentalDate(Date rentalDate);
    public void setVehicleId(String vehicleId);
    public void setIsPaid(boolean isPaid);
    public void setFee(float fee);

}
