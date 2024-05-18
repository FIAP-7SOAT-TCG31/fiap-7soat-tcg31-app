package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface ListItemsPortOut {
    List<Item> getAll();
}
