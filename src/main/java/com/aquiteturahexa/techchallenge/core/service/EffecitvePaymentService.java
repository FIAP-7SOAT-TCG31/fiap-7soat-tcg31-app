package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.ports.in.EffecitvePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;

public class EffecitvePaymentService implements EffecitvePaymentPortIn {


    private final UpdateOrderPortOut updateOrderPortOut;

    public EffecitvePaymentService(UpdateOrderPortOut updateOrderPortOut) {
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Order pay(Order order) {

        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        return this.updateOrderPortOut.update(order);
    }
}
