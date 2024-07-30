package com.cleanarchitecture.techchallenge.application.gateways;

import java.util.List;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;

public interface ListItemsGateway {
    List<Item> getAll();

    List<Item> getAllByType(ItemType itemType);
}
