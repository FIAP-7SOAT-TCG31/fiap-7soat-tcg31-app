package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ClientMapper;
import com.aquiteturahexa.techchallenge.core.model.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;
import com.aquiteturahexa.techchallenge.core.ports.out.ClientRepositoryPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClientRepositoryAdapter implements ClientRepositoryPort {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;

    @Override
    public Client save(Client client) {
        ClientEntity entity = ClientMapper.toEntity(client);
        return ClientMapper.toDomain(clientRepository.save(entity));
    }

    @Override
    public List<Client> findAll() {
        List<ClientEntity> list = clientRepository.findAll();

        return list
                .stream()
                .map(ClientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Client findByid(Long id) {
        Optional<ClientEntity> obj = clientRepository.findById(id);

        return obj.map(ClientMapper::toDomain)
                .orElse(null);

    }

    @Override
    public Client update(Long id, Client updateClient) {
        Client existClient = findByid(id);
        existClient.setName(updateClient.getName());
        existClient.setEmail(updateClient.getEmail());
        return save(existClient);
    }

    @Override
    public void deleteByid(Long id) {

        clientRepository.deleteById(id);
    }

}
