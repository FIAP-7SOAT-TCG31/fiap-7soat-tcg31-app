package com.cleanarchitecture.techchallenge.domain.usecases;

import java.util.List;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;

public interface ListItemsUseCase {
    List<Item> getAll();

    List<Item> getAllByType(ItemType itemType);
}
