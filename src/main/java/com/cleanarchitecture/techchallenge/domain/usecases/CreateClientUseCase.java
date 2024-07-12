package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

public interface CreateClientUseCase {
    Client create(Client client);
}
