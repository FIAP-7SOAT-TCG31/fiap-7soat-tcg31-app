package com.aquiteturahexa.techchallenge.core.service;

import java.util.Optional;

import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.in.GetItemPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetItemPortOut;

public class GetItemService implements GetItemPortIn {

    private final GetItemPortOut getItemPortOut;

    public GetItemService(GetItemPortOut getItemPortOut) {
        this.getItemPortOut = getItemPortOut;
    }

    @Override
    public Optional<Item> get(Long id) {
        return getItemPortOut.get(id);

    }

}
