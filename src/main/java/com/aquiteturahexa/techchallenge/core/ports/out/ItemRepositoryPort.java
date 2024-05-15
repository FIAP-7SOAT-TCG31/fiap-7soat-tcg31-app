package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface ItemRepositoryPort {
    Item save(Item item);

    List<Item> findAll();

    Item findById(Long id);

    Item update(Long id, Item item);
}
