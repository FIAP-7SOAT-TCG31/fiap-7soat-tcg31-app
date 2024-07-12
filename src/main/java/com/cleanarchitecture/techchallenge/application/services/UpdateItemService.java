package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateItemUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.item.GetItemGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.item.UpdateItemGateway;

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
        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setQuantity(item.getQuantity());
        existingItem.setType(item.getType());

        return updateItemGateway.update(existingItem);
    }

}
