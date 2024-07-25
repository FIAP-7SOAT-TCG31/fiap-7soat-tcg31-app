package com.cleanarchitecture.techchallenge.infra.gateways.client;

import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.persistence.entities.ClientEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientPersistenceAdapter implements CreateClientGateway {

    private final ClientJpaRepository clientJpaRepository;

    @Override
    public Client save(Client client) {
        ClientEntity entity = ClientEntity.toEntity(client);
        return ClientEntity.toDomain(clientJpaRepository.save(entity));
    }
}
