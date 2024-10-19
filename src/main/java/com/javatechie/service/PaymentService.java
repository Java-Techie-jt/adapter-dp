package com.javatechie.service;

import com.javatechie.adapter.GPayAdapter;
import com.javatechie.adapter.PayPalAdapter;
import com.javatechie.adapter.StripeAdapter;
import com.javatechie.processor.PaymentProcessor;
import com.javatechie.request.PaymentRequest;
import com.javatechie.response.PaymentResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    private Map<String, PaymentProcessor> paymentProcessorMap;
    //PayPalAdapter , PayPalAdapter.class

    public PaymentService(List<PaymentProcessor> paymentProcessors) {
        paymentProcessorMap = paymentProcessors.stream()
                .collect(Collectors.toMap(processor -> processor.getClass().getSimpleName(), Function.identity()));
    }

    public PaymentResponse processPayment(String gateway, PaymentRequest paymentRequest) {
        PaymentProcessor paymentProcessor = paymentProcessorMap.get(gateway + "Adapter");
        paymentProcessor.makePayment(paymentRequest.amount());
        return new PaymentResponse(true, new Random().nextLong(1000000000L));
    }


//    private PaymentProcessor getPaymentGatewayInstance(String gateway) {
//        PaymentProcessor processor = null;
//        switch (gateway.toLowerCase()) {
//            case "paypal":
//                processor = new PayPalAdapter();
//                break;
//            case "stripe":
//                processor = new StripeAdapter();
//                break;
//            case "gpay":
//                processor = new GPayAdapter();
//                break;
//        }
//        return processor;
//    }
}