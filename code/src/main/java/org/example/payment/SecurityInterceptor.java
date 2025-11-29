package org.example.payment;

public class SecurityInterceptor implements PaymentInterceptor {
    @Override
    public void postPayment(PaymentContent paymentContent) {
        System.out.println("[SECURITY] Transaction verified.");
    }

    @Override
    public void prePayment(PaymentContent paymentContent) {
        if (paymentContent.getCardNumber().startsWith("0000")) {
            throw new RuntimeException("Invalid card number detected!");
        }
    }
}
