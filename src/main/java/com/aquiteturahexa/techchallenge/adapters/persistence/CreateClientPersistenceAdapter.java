package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ClientMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ClientRepository;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateClientPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientPersistenceAdapter implements CreateClientPortOut {

    private final ClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        ClientEntity entity = ClientMapper.toEntity(client);
        return ClientMapper.toDomain(clientRepository.save(entity));
    }
}
