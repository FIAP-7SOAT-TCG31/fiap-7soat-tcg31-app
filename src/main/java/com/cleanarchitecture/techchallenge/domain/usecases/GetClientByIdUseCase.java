package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

import java.util.Optional;

public interface GetClientByIdUseCase {

    Optional<Client> find(Long id);
}
