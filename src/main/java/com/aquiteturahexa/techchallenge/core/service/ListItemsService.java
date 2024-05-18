package com.aquiteturahexa.techchallenge.core.service;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.in.ListItemsPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.ListItemsPortOut;

public class ListItemsService implements ListItemsPortIn {

    private final ListItemsPortOut listItemsPortOut;

    public ListItemsService(ListItemsPortOut listItemsPortOut) {
        this.listItemsPortOut = listItemsPortOut;
    }

    @Override
    public List<Item> getAll() {
        return listItemsPortOut.getAll();
    }

}
