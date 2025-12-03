package org.example.rental;

public class LoyaltyPointDecorator extends RentalDecorator{
    private float loyaltyPoints;

    public LoyaltyPointDecorator(IRentalOrder decoratedRentalOrder, float loyaltyPoints){
        super(decoratedRentalOrder);
        this.loyaltyPoints= loyaltyPoints;
    }

    @Override
    public float getLoyaltyPoints(){
        return (decoratedRentalOrder.getLoyaltyPoints() + loyaltyPoints);
    }

    @Override
    public String printRentalOrder(){
        return (decoratedRentalOrder.printRentalOrder()+"\nLoyalty Points Added: "+loyaltyPoints);
    }
}
