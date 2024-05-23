package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.Client;

import java.util.Optional;

public interface GetClientByIdPortOut {

    Optional<Client> find(Long id);
}
