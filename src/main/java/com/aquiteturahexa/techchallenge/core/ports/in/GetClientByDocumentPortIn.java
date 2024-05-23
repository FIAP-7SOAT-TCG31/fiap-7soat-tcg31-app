package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Client;

import java.util.Optional;

public interface GetClientByDocumentPortIn {

    Optional<Client> find(String cpf);
}
