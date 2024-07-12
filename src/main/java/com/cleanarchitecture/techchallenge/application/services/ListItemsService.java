package com.cleanarchitecture.techchallenge.application.services;

import java.util.List;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;
import com.cleanarchitecture.techchallenge.domain.usecases.ListItemsUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.item.ListItemsGateway;

public class ListItemsService implements ListItemsUseCase {

    private final ListItemsGateway listItemsGateway;

    public ListItemsService(ListItemsGateway listItemsGateway) {
        this.listItemsGateway = listItemsGateway;
    }

    @Override
    public List<Item> getAll() {
        return listItemsGateway.getAll();
    }

    @Override
    public List<Item> getAllByType(ItemType itemType) {
        return listItemsGateway.getAllByType(itemType);
    }

}
