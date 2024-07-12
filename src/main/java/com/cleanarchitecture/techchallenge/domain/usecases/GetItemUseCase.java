package com.cleanarchitecture.techchallenge.domain.usecases;

import java.util.Optional;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

public interface GetItemUseCase {
    Optional<Item> get(Long id);
}
