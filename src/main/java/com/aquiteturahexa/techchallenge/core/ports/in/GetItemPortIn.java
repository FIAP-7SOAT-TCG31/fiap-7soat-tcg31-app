package com.aquiteturahexa.techchallenge.core.ports.in;

import java.util.Optional;

import com.aquiteturahexa.techchallenge.core.model.Item;

public interface GetItemPortIn {
    Optional<Item> get(Long id);
}
