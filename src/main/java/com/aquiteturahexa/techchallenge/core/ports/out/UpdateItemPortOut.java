package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.Optional;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface UpdateItemPortOut {
    Item update(Item item);

    Optional<Item> findById(Long id);
}
