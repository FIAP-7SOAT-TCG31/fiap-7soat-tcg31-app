package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

public interface CreateClientGateway {

    Client save(Client client);
}
