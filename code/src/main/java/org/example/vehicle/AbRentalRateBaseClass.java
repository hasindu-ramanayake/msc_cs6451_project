package org.example.vehicle;

public abstract class AbRentalRateBaseClass {
    private int rate;

    public int getRate() {
        return rate;
    }

    abstract void calculateRentalRate();
}
