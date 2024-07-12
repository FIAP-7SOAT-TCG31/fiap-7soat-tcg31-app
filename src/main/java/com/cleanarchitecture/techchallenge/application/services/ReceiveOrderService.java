package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.OrderCannotBeUpdatedException;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.ReceiveOrderUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.order.UpdateOrderGateway;

import java.time.Instant;


public class ReceiveOrderService implements ReceiveOrderUseCase {

    private final UpdateOrderGateway updateOrderGateway;

    public ReceiveOrderService(UpdateOrderGateway updateOrderGateway) {
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order receive(Order order) {

        if (!Status.PAID.equals(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be received with status ".concat(order.getStatus().name()));
        }

        order.advance();

        return this.updateOrderGateway.update(order);
    }
}
