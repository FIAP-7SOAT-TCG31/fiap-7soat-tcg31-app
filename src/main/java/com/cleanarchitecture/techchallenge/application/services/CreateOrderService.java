package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.factories.OrderFactory;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateOrderUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.SaveOrderGateway;

public class CreateOrderService implements CreateOrderUseCase {

    private final SaveOrderGateway saveOrderGateway;

    public CreateOrderService(SaveOrderGateway saveOrderGateway) {
        this.saveOrderGateway = saveOrderGateway;
    }

    @Override
    public Order create(Combo combo, Client client) {
        var order = OrderFactory.getInstance().createOrderWithRequesterComboAmountStatus(client, combo, combo.calculate(), Status.CREATED);
        return saveOrderGateway.create(order);
    }
}
