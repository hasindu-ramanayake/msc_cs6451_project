package org.example.rental;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;

public class LoyaltyPointDecorator extends RentalDecorator{
    private float loyaltyPoints;

    public LoyaltyPointDecorator(IRentalOrder decoratedRentalOrder){
        super(decoratedRentalOrder);
        ISingleton customerMgr = CustomerMgr.getInstance();
        this.loyaltyPoints = ((CustomerMgr) customerMgr).getCustomerFromId(getCustomerId()).getCustomerTier().getLoyaltyPointMultiplier();
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