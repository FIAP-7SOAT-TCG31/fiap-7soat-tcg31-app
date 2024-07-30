package com.cleanarchitecture.techchallenge.application.gateways;

import java.util.Optional;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface GetItemGateway {
    Optional<Item> get(Long id);
}
