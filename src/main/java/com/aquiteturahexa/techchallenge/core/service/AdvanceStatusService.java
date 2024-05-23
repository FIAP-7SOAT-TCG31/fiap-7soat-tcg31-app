package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.ports.in.AdvanceStatusPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.EffecitvePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;

public class AdvanceStatusService implements AdvanceStatusPortIn {

    private final UpdateOrderPortOut updateOrderPortOut;

    public AdvanceStatusService(UpdateOrderPortOut updateOrderPortOut) {
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Order advance(Order order) {
        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        return this.updateOrderPortOut.update(order);
    }
}
