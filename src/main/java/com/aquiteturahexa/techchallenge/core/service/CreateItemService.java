package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateItemPortOut;

public class CreateItemService implements CreateItemPortIn {

    private final CreateItemPortOut createItemPortOut;

    public CreateItemService(CreateItemPortOut createItemPortOut) {
        this.createItemPortOut = createItemPortOut;
    }

    @Override
    public Item create(Item item) {
        return createItemPortOut.create(item);

    }

}
