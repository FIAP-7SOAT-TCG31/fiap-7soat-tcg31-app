package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface CreateItemUseCase {
    Item create(Item item);
}
