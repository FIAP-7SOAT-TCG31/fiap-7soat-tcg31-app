package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.exceptions.OrderCannotBeUpdatedException;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.ports.in.ReceiveOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;


public class ReceiveOrderService implements ReceiveOrderPortIn {

    private final UpdateOrderPortOut updateOrderPortOut;

    public ReceiveOrderService(UpdateOrderPortOut updateOrderPortOut) {
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Order receive(Order order) {

        if (!Status.PAID.equals(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be received with status ".concat(order.getStatus().name()));
        }

        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        return this.updateOrderPortOut.update(order);
    }
}
