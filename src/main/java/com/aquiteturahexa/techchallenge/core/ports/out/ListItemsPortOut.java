package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.model.ItemType;

public interface ListItemsPortOut {
    List<Item> getAll();

    List<Item> getAllByType(ItemType itemType);
}
