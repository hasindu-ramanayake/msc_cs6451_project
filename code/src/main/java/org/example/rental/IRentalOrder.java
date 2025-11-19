package org.example.rental;

import java.time.LocalDateTime;

public interface IRentalOrder {
    public String getOrderId(String orderId);
    public String getCustomerId();

    public LocalDateTime getRentalDate();
    public String getVehicleId();
    public double getFee();
    public boolean getIsPaid();
    public String printRentalOrder();

    public void setCustomerId();
    public void setRentalDate();
    public void setVehicleId();
    public void setIsPaid();
    public void setFee();





}
