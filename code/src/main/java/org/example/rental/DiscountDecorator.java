package org.example.rental;

public abstract class DiscountDecorator extends RentalDecorator{
    private float discountPercentage;

    public DiscountDecorator(IRentalOrder decoratedRentalOrder, float discountPercentage){
        super(decoratedRentalOrder);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public float getFee(){
        //get the original fee and subtract the discount
        return (decoratedRentalOrder.getFee() - decoratedRentalOrder.getFee()*(discountPercentage/100) );
    }
    //Adds an extra line under the print order receipt
    @Override
    public String printRentalOrder(){
        return (decoratedRentalOrder.printRentalOrder()+"\nDiscounted Price: "+getFee()) ;
    }

}
