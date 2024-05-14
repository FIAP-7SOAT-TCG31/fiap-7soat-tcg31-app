package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateItemPortOut;

public class CreateItemService implements CreateItemPortIn {

    private final CreateItemPortOut createOrderPortOut;

    public CreateItemService(CreateItemPortOut createItemPortOut) {
        createOrderPortOut = createItemPortOut;
    }

    @Override
    public Item create(Item item) {
        return createOrderPortOut.create(item);

    }

}
