package org.example.payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentDispatcher {
    private final List<PaymentInterceptor> interceptors;

    public PaymentDispatcher() {
        this.interceptors = new ArrayList<>();
    }

    public void registerInterceptor(PaymentInterceptor interceptor) {
        interceptors.add(interceptor);
    }

    public boolean processPayment(PaymentContent context) {
        for (PaymentInterceptor interceptor : interceptors) {
            interceptor.prePayment(context);
        }

        System.out.println("Processing payment of " + context.getAmount() + " " + context.getCurrency());
        for (PaymentInterceptor interceptor : interceptors) {
            interceptor.postPayment(context);
        }
        return true;
    }

}
