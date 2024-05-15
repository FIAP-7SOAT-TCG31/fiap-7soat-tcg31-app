package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface UpdateItemPortOut {
    Item update(Item item);

    Item findById(Long id);
}
