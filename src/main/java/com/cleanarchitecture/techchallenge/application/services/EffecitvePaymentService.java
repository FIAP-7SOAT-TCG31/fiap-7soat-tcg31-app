package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.OrderCannotBeUpdatedException;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.EffecitvePaymentUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.UpdateOrderGateway;

import java.time.Instant;

public class EffecitvePaymentService implements EffecitvePaymentUseCase {


    private final UpdateOrderGateway updateOrderGateway;

    public EffecitvePaymentService(UpdateOrderGateway updateOrderGateway) {
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order pay(Order order) {

        if (!Status.AWAITING_PAYMENT.equals(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be updated with status ".concat(order.getStatus().name()));
        }
        
        order.getPayment().setPaid(Instant.now());
        order.advance();
        return this.updateOrderGateway.update(order);
    }
}
