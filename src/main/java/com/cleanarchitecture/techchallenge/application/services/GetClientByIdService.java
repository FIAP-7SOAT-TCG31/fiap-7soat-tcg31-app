package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByIdUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.GetClientByIdGateway;

import java.util.Optional;

public class GetClientByIdService implements GetClientByIdUseCase {

    private final GetClientByIdGateway getClientByIdGateway;

    public GetClientByIdService(GetClientByIdGateway getClientByIdGateway) {
        this.getClientByIdGateway = getClientByIdGateway;
    }

    @Override
    public Optional<Client> find(Long id) {
        return getClientByIdGateway.find(id);
    }
}
