package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.OrderCannotBeUpdatedException;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.RefusedPaymentUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.order.UpdateOrderGateway;

import java.util.List;

public class RefusedPaymentService implements RefusedPaymentUseCase {

    private final static List<Status> ALLOWED = List.of(Status.CREATED, Status.AWAITING_PAYMENT);
    private final UpdateOrderGateway updateOrderGateway;

    public RefusedPaymentService(UpdateOrderGateway updateOrderGateway) {
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order refused(Order order) {

        if (!ALLOWED.contains(order.getStatus())) {
            throw new OrderCannotBeUpdatedException("Order cannot be updated with status ".concat(order.getStatus().name()));
        }

        order.cancel();
        return this.updateOrderGateway.update(order);
    }
}
