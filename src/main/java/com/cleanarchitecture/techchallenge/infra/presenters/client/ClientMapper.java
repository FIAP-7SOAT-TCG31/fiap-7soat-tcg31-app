package com.cleanarchitecture.techchallenge.infra.presenters.client;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.Cpf;
import com.cleanarchitecture.techchallenge.domain.entities.Email;

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
                .withEmail(client.getEmail() == null ? null : client.getEmail().email())
                .withCpf(client.getCpf() == null ? null : client.getCpf().number())
                .build();
    }
}

