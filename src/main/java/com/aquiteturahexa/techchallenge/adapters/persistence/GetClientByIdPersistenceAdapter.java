package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ClientMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ClientRepository;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByDocumentPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByIdPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetClientByIdPersistenceAdapter implements GetClientByIdPortOut {

    private final ClientRepository clientRepository;


    @Override
    public Optional<Client> find(Long id) {
        var clientEntity = clientRepository.findById(id);
        return clientEntity.map(ClientMapper::toDomain);
    }
}
