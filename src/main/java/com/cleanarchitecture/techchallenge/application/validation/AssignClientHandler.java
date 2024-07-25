package com.cleanarchitecture.techchallenge.application.validation;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public class AssignClientHandler implements PaymentValidationHandler {
    private PaymentValidationHandler next;

    @Override
    public void setNext(PaymentValidationHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(Order order, Client client, String paymentType) {
        if (order.getRequester() == null) {
            order.setRequester(client);
        }
        if (next != null) {
            next.handle(order, client, paymentType);
        }
    }
}