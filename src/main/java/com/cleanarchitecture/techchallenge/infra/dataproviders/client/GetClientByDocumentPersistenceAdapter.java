package com.cleanarchitecture.techchallenge.infra.dataproviders.client;

import com.cleanarchitecture.techchallenge.application.gateways.GetClientByDocumentGateway;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.persistence.entities.ClientEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.ClientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetClientByDocumentPersistenceAdapter implements GetClientByDocumentGateway {

    private final ClientJpaRepository clientJpaRepository;

    @Override
    public Optional<Client> find(String cpf) {
        var clientEntity = clientJpaRepository.findByCpf(cpf);
        return Optional.ofNullable(ClientEntity.toDomain(clientEntity));
    }
}
