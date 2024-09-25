package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.gateways.GetClientByDocumentGateway;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateClientUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.CreateClientGateway;

public class CreateClientService implements CreateClientUseCase {

    private final CreateClientGateway createClientGateway;
    private final GetClientByDocumentGateway getClientByDocumentGateway;

    public CreateClientService(CreateClientGateway createClientGateway,
                               GetClientByDocumentGateway getClientByDocumentGateway) {
        this.createClientGateway = createClientGateway;
        this.getClientByDocumentGateway = getClientByDocumentGateway;
    }

    @Override
    public Client create(Client client) {
        var clientExists = getClientByDocumentGateway.find(client.getCpf().number());
        return clientExists.orElseGet(() -> createClientGateway.save(client));
    }
}
