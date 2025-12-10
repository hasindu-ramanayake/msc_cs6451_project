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
//        System.out.println("decoratedRentalOrder: "+ decoratedRentalOrder.getFee());
//        System.out.println("decoratedRentalOrder reduction: "+ decoratedRentalOrder.getFee()*(discountPercentage) );
        return decoratedRentalOrder.getFee() - decoratedRentalOrder.getFee()*(discountPercentage);
//        System.out.println("decoratedRentalOrder price: "+ price );
    }
    //Adds an extra line under the print order receipt
    @Override
    public String printRentalOrder(){
        return (decoratedRentalOrder.printRentalOrder()+"\nDiscounted Price: "+ this.getFee());
    }

    @Override
    public String toString() {
        return "DiscountCodeDecorator{" +
                "discountPercentage=" + discountPercentage +
                ", decoratedRentalOrder=" + decoratedRentalOrder +
                '}';
    }
}