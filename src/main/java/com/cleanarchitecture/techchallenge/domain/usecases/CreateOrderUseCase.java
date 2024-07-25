package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

public interface CreateOrderUseCase {
    Order create(Combo combo, Client client);
}
