package com.javatechie.adapter;

import com.javatechie.processor.PaymentProcessor;
import org.springframework.stereotype.Component;

@Component
public class PhonePeAdapter implements PaymentProcessor {

    @Override
    public void makePayment(double amount) {
        //call actual phonePe api
        System.out.println("Payment processed via PhonePe: " + amount);
    }
}
