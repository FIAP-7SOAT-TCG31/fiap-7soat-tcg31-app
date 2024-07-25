package com.cleanarchitecture.techchallenge.infra.gateways.item;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface UpdateItemGateway {
    Item update(Item item);
}
