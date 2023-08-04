package br.com.softexpert.divisaocontasapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PaymentProcessorFactory {
    private final Map<String, PaymentProcessor> processors;

    @Autowired
    public PaymentProcessorFactory(List<PaymentProcessor> paymentProcessors) {
        processors = new HashMap<>();
        for (PaymentProcessor processor : paymentProcessors) {
            processors.put(processor.getClass().getSimpleName(), processor);
        }
    }

    public PaymentProcessor createPaymentProcessor(String type) {
        return processors.get(type);
    }
}

