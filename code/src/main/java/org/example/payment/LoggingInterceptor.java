package org.example.payment;

public class LoggingInterceptor implements PaymentInterceptor {
    @Override
    public void prePayment(PaymentContent paymentContent) {
        System.out.println("[LOG] Initiating payment for user: " + paymentContent.getUserId());
    }

    @Override
    public void postPayment(PaymentContent paymentContent) {
        System.out.println("[LOG] Payment completed for user: " + paymentContent.getUserId());
    }
}
