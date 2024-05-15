package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface UpdateItemPortIn {
    Item update(Long id, Item item);
}
