package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ClientDto;
import com.aquiteturahexa.techchallenge.core.model.Client;

import static java.util.Objects.isNull;

public class ClientMapper {

    public static Client toDomain(ClientDto client) {
        return isNull(client)
                ? null
                : new Client(client.getId(),
                isNull(client.getCpf()) ? null : Long.valueOf(client.getCpf()),
                client.getName(),
                client.getEmail());
    }
}

