package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateItemUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.CreateItemGateway;

public class CreateItemService implements CreateItemUseCase {

    private final CreateItemGateway createItemGateway;

    public CreateItemService(CreateItemGateway createItemGateway) {
        this.createItemGateway = createItemGateway;
    }

    @Override
    public Item create(Item item) {
        return createItemGateway.create(item);
    }

}
