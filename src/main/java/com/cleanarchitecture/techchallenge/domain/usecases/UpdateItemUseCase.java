package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface UpdateItemUseCase {
    Item update(Long id, Item item);
}
