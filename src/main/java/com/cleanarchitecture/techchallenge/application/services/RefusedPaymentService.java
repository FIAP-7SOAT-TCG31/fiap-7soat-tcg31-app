package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.usecases.RefusedPaymentUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.order.UpdateOrderGateway;

public class RefusedPaymentService implements RefusedPaymentUseCase {


    private final UpdateOrderGateway updateOrderGateway;

    public RefusedPaymentService(UpdateOrderGateway updateOrderGateway) {
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order refused(Order order) {

        order.cancel();
        return this.updateOrderGateway.update(order);
    }
}
