package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateItemUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.GetItemGateway;
import com.cleanarchitecture.techchallenge.application.gateways.UpdateItemGateway;

public class UpdateItemService implements UpdateItemUseCase {

    private final GetItemGateway getItemGateway;
    private final UpdateItemGateway updateItemGateway;

    public UpdateItemService(GetItemGateway getItemGateway,
                             UpdateItemGateway updateItemGateway) {
        this.getItemGateway = getItemGateway;
        this.updateItemGateway = updateItemGateway;
    }

    @Override
    public Item update(Long id, Item item) {
        var maybeExistingItem = getItemGateway.get(id);

        if (maybeExistingItem.isEmpty()) {
            return null;
        }

        var existingItem = maybeExistingItem.get();
        existingItem.update(item);

        return updateItemGateway.update(existingItem);
    }

}
