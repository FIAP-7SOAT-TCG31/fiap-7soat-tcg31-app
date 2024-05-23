package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.exceptions.OrderCannotBeUpdatedException;
import com.aquiteturahexa.techchallenge.core.model.Combo;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.math.BigDecimal;

public class UpdateOrderService implements UpdateOrderPortIn {

    private final UpdateOrderPortOut updateOrderPortOut;

    public UpdateOrderService(UpdateOrderPortOut updateOrderPortOut) {
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Order update(Order order, Combo combo) {

        if (order.getStatus() != Status.CREATED) {
            throw new OrderCannotBeUpdatedException("Status is not CREATED");
        }

        order.setCombo(combo);
        order.setAmount(combo == null
                ? BigDecimal.ZERO
                : combo.calculate());
        return updateOrderPortOut.update(order);
    }
}
