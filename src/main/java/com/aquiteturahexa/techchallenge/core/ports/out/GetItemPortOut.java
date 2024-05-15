package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.Optional;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface GetItemPortOut {
    Optional<Item> get(Long id);
}
