package com.aquiteturahexa.techchallenge.core.service;

import static java.util.Objects.isNull;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateItemPortOut;

public class UpdateItemService implements UpdateItemPortIn {

    private final UpdateItemPortOut updateItemPortOut;

    public UpdateItemService(UpdateItemPortOut updateItemPortOut) {
        this.updateItemPortOut = updateItemPortOut;
    }

    @Override
    public Item update(Long id, Item item) {
        var existingItem = updateItemPortOut.findById(id);

        if (isNull(existingItem)) {
            return null;
        }

        existingItem.setName(item.getName());
        existingItem.setPrice(item.getPrice());
        existingItem.setQuantity(item.getQuantity());
        existingItem.setType(item.getType());

        return updateItemPortOut.update(existingItem);
    }

}
