package com.cleanarchitecture.techchallenge.application.validation;

import com.cleanarchitecture.techchallenge.application.exceptions.PaymentNotValidException;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public class ClientInformedHandler implements PaymentValidationHandler {
    private PaymentValidationHandler next;

    @Override
    public void setNext(PaymentValidationHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(Order order, Client client, String paymentType) throws PaymentNotValidException {
        if (order.getRequester() == null && client == null) {
            throw new PaymentNotValidException("Client not informed");
        }
        if (next != null) {
            next.handle(order, client, paymentType);
        }
    }
}