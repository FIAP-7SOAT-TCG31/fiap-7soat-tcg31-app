package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByDocumentUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.client.GetClientByDocumentGateway;

import java.util.Optional;

public class GetClientByDocumentService implements GetClientByDocumentUseCase {

    private final GetClientByDocumentGateway getClientByDocumentGateway;

    public GetClientByDocumentService(GetClientByDocumentGateway getClientByDocumentGateway) {
        this.getClientByDocumentGateway = getClientByDocumentGateway;
    }

    @Override
    public Optional<Client> find(String cpf) {
        return getClientByDocumentGateway.find(cpf);
    }
}
