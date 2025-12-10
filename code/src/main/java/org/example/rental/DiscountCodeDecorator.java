package org.example.rental;

public class DiscountCodeDecorator extends RentalDecorator{
    private final float discountPercentage;

    protected DiscountCodeDecorator(IRentalOrder decoratedRentalOrder, float discountPercentage){
        super(decoratedRentalOrder);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public float getFee(){
        //get the original fee and subtract the discount
        return (decoratedRentalOrder.getFee() - decoratedRentalOrder.getFee()*(discountPercentage) );
    }
    //Adds an extra line under the print order receipt
    @Override
    public String printRentalOrder(){
        return (decoratedRentalOrder.printRentalOrder()+"\nDiscounted Price: "+getFee());
    }

}