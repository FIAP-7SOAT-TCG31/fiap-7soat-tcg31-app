package com.aquiteturahexa.techchallenge.core.ports.in;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Client;

public interface ClientServicePort {

    List<Client> findAll();

    Client saveClient(Client client);

    Client findById(Long id);

    Client updateClient(Long id, Client client);

    void deleteById(Long id);
}