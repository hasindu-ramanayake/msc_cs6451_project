package org.example.payment;

import org.example.core.AbLoggerFactory;
import org.example.core.ILogger;
import org.example.core.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class PaymentDispatcher {
    private final List<PaymentInterceptor> interceptors;
    private final ILogger logger;

    public PaymentDispatcher() {
        AbLoggerFactory log = new LoggerFactory();
        this.logger = log.createLogger();
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
