package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.Client;

public interface CreateClientPortOut {

    Client save(Client client);
}
