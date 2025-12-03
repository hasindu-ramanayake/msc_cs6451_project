package org.example.payment;

public class CardPaymentGateway implements IPaymentGateway{
    @Override
    public boolean pay(PaymentContent paymentData) {
        PaymentDispatcher dispatcher = new PaymentDispatcher();

        dispatcher.registerInterceptor(new LoggingInterceptor());
        dispatcher.registerInterceptor(new SecurityInterceptor());
        dispatcher.registerInterceptor(new FraudCheckInterceptor());

        return dispatcher.processPayment(paymentData);
    }
}
