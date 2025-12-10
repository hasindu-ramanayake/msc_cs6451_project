package org.example.payment;

public class FraudCheckInterceptor implements PaymentInterceptor {
    @Override
    public void prePayment(PaymentContent paymentContent) {
        if (paymentContent.getAmount() > 10000) {
            System.out.println("[FRAUD ALERT] High-value transaction detected!");
        }
    }

    @Override
    public void postPayment(PaymentContent paymentContent) {
        System.out.println("Payment done.");
    }

}
