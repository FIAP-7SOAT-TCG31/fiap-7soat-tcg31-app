package com.cleanarchitecture.techchallenge.infra.dataproviders.client;

import com.cleanarchitecture.techchallenge.application.gateways.GetClientByIdGateway;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.persistence.entities.ClientEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetClientByIdPersistenceAdapter implements GetClientByIdGateway {

    private final ClientJpaRepository clientJpaRepository;


    @Override
    public Optional<Client> find(Long id) {
        var clientEntity = clientJpaRepository.findById(id);
        return clientEntity.map(ClientEntity::toDomain);
    }
}
