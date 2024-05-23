package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.exceptions.OrderCannotBeUpdatedException;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.ports.in.EffecitvePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;
import java.util.List;

public class EffecitvePaymentService implements EffecitvePaymentPortIn {


    private final UpdateOrderPortOut updateOrderPortOut;

    public EffecitvePaymentService(UpdateOrderPortOut updateOrderPortOut) {
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Order pay(Order order) {

        if (!Status.AWAITING_PAYMENT.equals(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be updated with status ".concat(order.getStatus().name()));
        }
        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        return this.updateOrderPortOut.update(order);
    }
}
