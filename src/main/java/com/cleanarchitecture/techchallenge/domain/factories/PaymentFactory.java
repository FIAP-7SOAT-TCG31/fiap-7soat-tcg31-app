package com.cleanarchitecture.techchallenge.domain.factories;

import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PaymentFactory {

    private static PaymentFactory instance;

    private PaymentFactory() {
    }

    public static PaymentFactory getInstance() {
        if (instance == null) {
            instance = new PaymentFactory();
        }

        return instance;
    }

    public Payment createPayment(String paymentType) {
        return new Payment(UUID.randomUUID().toString(), paymentType, new ArrayList<>(), false, null);
    }
}
