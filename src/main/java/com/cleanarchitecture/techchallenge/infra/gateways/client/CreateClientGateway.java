package com.cleanarchitecture.techchallenge.infra.gateways.client;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

public interface CreateClientGateway {

    Client save(Client client);
}
