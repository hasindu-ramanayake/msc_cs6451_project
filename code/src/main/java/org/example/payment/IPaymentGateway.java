package org.example.payment;

public interface IPaymentGateway {
    public boolean pay(PaymentContent paymentData);
}
