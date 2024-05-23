package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.exceptions.OrderCannotBeUpdatedException;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.ports.in.AdvanceStatusPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;
import java.util.List;

public class AdvanceStatusService implements AdvanceStatusPortIn {

    private final static List<Status> NOT_ALLOWED = List.of(Status.CREATED, Status.AWAITING_PAYMENT, Status.FINISHED);
    private final UpdateOrderPortOut updateOrderPortOut;

    public AdvanceStatusService(UpdateOrderPortOut updateOrderPortOut) {
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Order advance(Order order) {

        if (NOT_ALLOWED.contains(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be updated with status ".concat(order.getStatus().name()));
        }
        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        return this.updateOrderPortOut.update(order);
    }
}
