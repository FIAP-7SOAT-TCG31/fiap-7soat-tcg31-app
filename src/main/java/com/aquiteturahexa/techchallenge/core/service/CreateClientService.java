package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateClientPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateClientPortOut;

public class CreateClientService implements CreateClientPortIn {

    private final CreateClientPortOut createClientPortOut;

    public CreateClientService(CreateClientPortOut createClientPortOut) {
        this.createClientPortOut = createClientPortOut;
    }

    @Override
    public Client create(Client client) {
        return createClientPortOut.save(client);
    }
}
