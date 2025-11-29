package org.example.payment;

public interface PaymentInterceptor {
    public void prePayment(PaymentContent paymentContent);
    public void postPayment(PaymentContent paymentContent);
}
