package com.cleanarchitecture.techchallenge.application.validation;

import com.cleanarchitecture.techchallenge.application.exceptions.PaymentNotValidException;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface PaymentValidationHandler {

    void setNext(PaymentValidationHandler handler);
    void handle(Order order, Client client, String paymentType) throws PaymentNotValidException;
}
