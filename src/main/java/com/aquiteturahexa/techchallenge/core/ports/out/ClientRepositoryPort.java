package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Client;

public interface ClientRepositoryPort {
    Client save(Client client);

    List<Client> findAll();

    Client findByid(Long id);

    Client update(Long id, Client client);

    void deleteByid(Long id);
}
