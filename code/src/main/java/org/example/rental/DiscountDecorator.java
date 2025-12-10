package org.example.rental;

import org.example.core.ISingleton;
import org.example.customer.CustomerMgr;

public abstract class DiscountDecorator extends RentalDecorator{
    private float discountPercentage;

    protected DiscountDecorator(IRentalOrder decoratedRentalOrder){
        super(decoratedRentalOrder);
        ISingleton customerMgr = CustomerMgr.getInstance();
        this.discountPercentage = ((CustomerMgr) customerMgr).getCustomerFromId(getCustomerId()).getCustomerTier().getDiscountMultiplier();
    }

    @Override
    public float getFee(){
        //get the original fee and subtract the discount
        return (decoratedRentalOrder.getFee() - decoratedRentalOrder.getFee()*(discountPercentage) );
    }
    //Adds an extra line under the print order receipt
    @Override
    public String printRentalOrder(){
        return (decoratedRentalOrder.printRentalOrder()+"\nDiscounted Price: "+getFee()) ;
    }

}