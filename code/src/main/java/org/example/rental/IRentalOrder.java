package org.example.rental;

import java.time.LocalDateTime;
import java.util.Random;

public interface IRentalOrder {

    public String getOrderId(String orderId);
    public String getCustomerId();

    public String generateId();

    public LocalDateTime getRentalDate();
    public String getVehicleId();
    public double getFee();
    public boolean getIsPaid();
    public String printRentalOrder();

    public void setCustomerId(String customerId);
    public void setRentalDate(LocalDateTime rentalDate);
    public void setVehicleId(String vehicleId);
    public void setIsPaid(boolean isPaid);
    public void setFee(double fee);

}
