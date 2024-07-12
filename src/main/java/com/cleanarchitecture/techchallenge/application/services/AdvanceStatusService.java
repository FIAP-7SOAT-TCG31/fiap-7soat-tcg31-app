package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.OrderCannotBeUpdatedException;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.AdvanceStatusUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.order.UpdateOrderGateway;

import java.time.Instant;
import java.util.List;

public class AdvanceStatusService implements AdvanceStatusUseCase {

    private final static List<Status> NOT_ALLOWED = List.of(Status.CREATED, Status.AWAITING_PAYMENT, Status.FINISHED);
    private final UpdateOrderGateway updateOrderGateway;

    public AdvanceStatusService(UpdateOrderGateway updateOrderGateway) {
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order advance(Order order) {

        if (NOT_ALLOWED.contains(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be updated with status ".concat(order.getStatus().name()));
        }
        order.advance();
        return this.updateOrderGateway.update(order);
    }
}
