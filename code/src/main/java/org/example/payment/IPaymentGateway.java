package org.example.payment;

public interface IPaymentGateway {
    public void pay();
    public void refund();
    public void log();
}
