package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.OrderCannotBeUpdatedException;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.AdvanceStatusUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.UpdateOrderGateway;

import java.util.List;

public class AdvanceStatusService implements AdvanceStatusUseCase {

    private final List<Status> notAllowed;
    private final UpdateOrderGateway updateOrderGateway;

    public AdvanceStatusService(
            List<Status> notAllowed,
            UpdateOrderGateway updateOrderGateway) {
        this.notAllowed = notAllowed;
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order advance(Order order) {

        if (notAllowed.contains(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be updated with status ".concat(order.getStatus().name()));
        }
        order.advance();
        return this.updateOrderGateway.update(order);
    }
}
