package com.cleanarchitecture.techchallenge.infra.gateways.payment;


import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

public interface GeneratePaymentGateway {

    Payment generate(Payment payment, Order order);

    boolean isType(Payment payment);
}
