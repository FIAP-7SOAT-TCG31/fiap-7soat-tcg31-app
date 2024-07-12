package com.cleanarchitecture.techchallenge.infra.gateways.item;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface CreateItemGateway {
    Item create(Item item);
}
