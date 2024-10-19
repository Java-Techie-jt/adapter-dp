package com.javatechie.adapter;

import com.javatechie.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class GPayAdapter implements PaymentProcessor {


    public void makePayment(double amount) {
        // Gpay-specific logic to process payment
        System.out.println("Payment processed via Gpay: " + amount);
    }
}
