package com.cleanarchitecture.techchallenge.application.validation;

import com.cleanarchitecture.techchallenge.application.exceptions.PaymentNotValidException;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

import java.math.BigDecimal;

public class OrderAmountHandler implements PaymentValidationHandler {
    private PaymentValidationHandler next;

    @Override
    public void setNext(PaymentValidationHandler handler) {
        this.next = handler;
    }

    @Override
    public void handle(Order order, Client client, String paymentType) throws PaymentNotValidException {
        if (order.getCombo().calculate().equals(BigDecimal.ZERO)) {
            throw new PaymentNotValidException("Order with no amount");
        }
        if (next != null) {
            next.handle(order, client, paymentType);
        }
    }
}