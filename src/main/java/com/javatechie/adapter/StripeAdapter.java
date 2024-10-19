package com.javatechie.adapter;

import com.javatechie.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class StripeAdapter implements PaymentProcessor {

    public void makePayment(double amount) {
        // Stripe-specific logic to process payment
        System.out.println("Payment processed via Stripe: " + amount);
    }
}
