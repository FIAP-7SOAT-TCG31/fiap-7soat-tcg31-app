package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateClientUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.CreateClientGateway;

public class CreateClientService implements CreateClientUseCase {

    private final CreateClientGateway createClientGateway;

    public CreateClientService(CreateClientGateway createClientGateway) {
        this.createClientGateway = createClientGateway;
    }

    @Override
    public Client create(Client client) {
        return createClientGateway.save(client);
    }
}
