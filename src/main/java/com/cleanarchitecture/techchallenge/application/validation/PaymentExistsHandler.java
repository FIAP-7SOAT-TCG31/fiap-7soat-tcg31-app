package com.cleanarchitecture.techchallenge.application.validation;

import com.cleanarchitecture.techchallenge.application.exceptions.PaymentNotValidException;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public class PaymentExistsHandler implements PaymentValidationHandler {

    private PaymentValidationHandler next;

    @Override
    public void setNext(PaymentValidationHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(Order order, Client client, String paymentType) throws PaymentNotValidException {

        if (order.getPayment() != null) {
            throw new IllegalArgumentException("Payment already exists.");
        }
        if (next != null) {
            next.handle(order, client, paymentType);
        }
    }
}