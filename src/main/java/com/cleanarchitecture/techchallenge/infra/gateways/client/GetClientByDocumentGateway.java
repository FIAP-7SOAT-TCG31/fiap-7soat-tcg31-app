package com.cleanarchitecture.techchallenge.infra.gateways.client;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;

import java.util.Optional;

public interface GetClientByDocumentGateway {

    Optional<Client> find(String cpf);
}
