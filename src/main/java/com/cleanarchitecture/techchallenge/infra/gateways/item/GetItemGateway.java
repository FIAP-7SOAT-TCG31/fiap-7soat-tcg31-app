package com.cleanarchitecture.techchallenge.infra.gateways.item;

import java.util.Optional;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface GetItemGateway {
    Optional<Item> get(Long id);
}
