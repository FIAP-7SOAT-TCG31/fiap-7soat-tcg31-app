package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ClientDto;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.model.Cpf;
import com.aquiteturahexa.techchallenge.core.model.Email;

import static java.util.Objects.isNull;

public class ClientMapper {

    public static Client toDomain(ClientDto client) {
        return isNull(client)
                ? null
                : new Client(client.getId(),
                client.getCpf() == null ? null : new Cpf(client.getCpf()),
                client.getName() == null ? null : client.getName(),
                client.getEmail() == null ? null : new Email(client.getEmail()));
    }
}

