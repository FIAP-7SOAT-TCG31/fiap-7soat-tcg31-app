package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ClientDto;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.model.Cpf;
import com.aquiteturahexa.techchallenge.core.model.Email;

import static java.util.Objects.isNull;

public class ClientMapper {

    public static Client toDomain(ClientDto client) {
        return client == null
                ? null
                : new Client(client.getId(),
                client.getCpf() == null ? null : new Cpf(client.getCpf()),
                client.getName() == null ? null : client.getName(),
                client.getEmail() == null ? null : new Email(client.getEmail()));
    }

    public static ClientDto toDto(Client client) {
        return client == null
                ? null
                : ClientDto
                .builder()
                .withId(client.getId())
                .withName(client.getName())
                .withEmail(client.getEmail() == null ? null : client.getEmail().getEmail())
                .withCpf(client.getCpf() == null ? null : client.getCpf().getNumber())
                .build();
    }
}

