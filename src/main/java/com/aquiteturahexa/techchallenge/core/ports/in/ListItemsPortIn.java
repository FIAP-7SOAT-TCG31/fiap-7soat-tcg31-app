package com.aquiteturahexa.techchallenge.core.ports.in;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.model.ItemType;

public interface ListItemsPortIn {
    List<Item> getAll();

    List<Item> getAllByType(ItemType itemType);
}
