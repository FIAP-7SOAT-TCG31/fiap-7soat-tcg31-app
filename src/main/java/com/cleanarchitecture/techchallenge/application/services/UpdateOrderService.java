package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.OrderCannotBeUpdatedException;
import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateOrderUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.UpdateOrderGateway;

public class UpdateOrderService implements UpdateOrderUseCase {

    private final UpdateOrderGateway updateOrderGateway;

    public UpdateOrderService(UpdateOrderGateway updateOrderGateway) {
        this.updateOrderGateway = updateOrderGateway;
    }

    @Override
    public Order update(Order order, Combo combo) {

        if (order.getStatus() != Status.CREATED) {
            throw new OrderCannotBeUpdatedException("Status is not CREATED");
        }

        order.updateCombo(combo);
        return updateOrderGateway.update(order);
    }
}
