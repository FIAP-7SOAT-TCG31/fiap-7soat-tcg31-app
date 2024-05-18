package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ClientMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ClientRepository;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByDocumentPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetClientByDocumentPersistenceAdapter implements GetClientByDocumentPortOut {

    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> find(String cpf) {
        var clientEntity = clientRepository.findByCpf(cpf);
        return Optional.ofNullable(ClientMapper.toDomain(clientEntity));
    }
}
