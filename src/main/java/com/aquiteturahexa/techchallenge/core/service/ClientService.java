package com.aquiteturahexa.techchallenge.core.service;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.out.ClientRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.in.ClientServicePort;

public class ClientService implements ClientServicePort {

    private final ClientRepositoryPort clientRepositoryPort;

    public ClientService(ClientRepositoryPort clientRepositoryPort) {

        this.clientRepositoryPort = clientRepositoryPort;
    }

    @Override
    public List<Client> findAll() {
        return clientRepositoryPort.findAll();
    }

    @Override
    public Client saveClient(Client client) {

        return clientRepositoryPort.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepositoryPort.findByid(id);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        return clientRepositoryPort.update(id, client);
    }

    @Override
    public void deleteById(Long id) {
        clientRepositoryPort.deleteByid(id);
    }

}
