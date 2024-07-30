package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface CreateItemGateway {
    Item create(Item item);
}
