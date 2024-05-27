package com.aquiteturahexa.techchallenge.adapters.persistence.mapper;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.model.Cpf;
import com.aquiteturahexa.techchallenge.core.model.Email;

import static java.util.Objects.isNull;

public class ClientMapper {

    public static ClientEntity toEntity(Client requester) {
        return isNull(requester)
                ? null
                : ClientEntity
                .builder()
                .withId(requester.getId())
                .withCpf(requester.getCpf().getNumber())
                .withName(requester.getName())
                .withEmail(requester.getEmail().getEmail())
                .build();
    }

    public static Client toDomain(ClientEntity requester) {
        return isNull(requester)
                ? null
                : new Client(requester.getId(),
                new Cpf(requester.getCpf()),
                requester.getName(),
                new Email(requester.getEmail()));
    }
}
