package com.aquiteturahexa.techchallenge.adapters.persistence.mapper;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;
import com.aquiteturahexa.techchallenge.core.model.Client;

import static java.util.Objects.isNull;

public class ClientMapper {

    public static ClientEntity toEntity(Client requester) {
        return isNull(requester)
                ? null
                : ClientEntity
                        .builder()
                        .withId(requester.getId())
                        .withCpf(String.valueOf(requester.getCPF()))
                        .withName(requester.getName())
                        .withEmail(requester.getEmail())
                        .build();
    }

    public static Client toDomain(ClientEntity requester) {
        return isNull(requester)
                ? null
                : new Client(requester.getId(), Long.valueOf(requester.getCpf()), requester.getName(),
                        requester.getEmail());
    }
}
