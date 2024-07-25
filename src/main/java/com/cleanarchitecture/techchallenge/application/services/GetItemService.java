package com.cleanarchitecture.techchallenge.application.services;

import java.util.Optional;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.usecases.GetItemUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.item.GetItemGateway;

public class GetItemService implements GetItemUseCase {

    private final GetItemGateway getItemGateway;

    public GetItemService(GetItemGateway getItemGateway) {
        this.getItemGateway = getItemGateway;
    }

    @Override
    public Optional<Item> get(Long id) {
        return getItemGateway.get(id);

    }

}
