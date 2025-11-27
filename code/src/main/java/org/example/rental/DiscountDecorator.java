package org.example.rental;

import java.time.LocalDateTime;

public class DiscountDecorator extends RentalDecorator{
    private double discountPercentage;

    public DiscountDecorator(IRentalOrder decoratedRentalOrder, double discountPercentage){
        super(decoratedRentalOrder);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getFee(){
        //get the original fee and subtract the discount
        double fee = decoratedRentalOrder.getFee();
        double discount = fee * (discountPercentage/100);
        double newFee = fee - discount;
        return newFee;
    }
    //Adds an extra line under the print order receipt
    @Override
    public String printRentalOrder(){
        return decoratedRentalOrder.printRentalOrder()+"\nDiscounted Price: "+getFee();
    }

}
