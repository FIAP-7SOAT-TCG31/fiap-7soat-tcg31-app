package com.cleanarchitecture.techchallenge.infra.controllers.client;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateClientUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import org.springframework.stereotype.Component;

@Component
public class CreateClientController {

    private final CreateClientUseCase createClientUseCase;
    private final ClientPresenter clientPresenter;

    public CreateClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.clientPresenter = ClientPresenter.getInstance();
    }


    public ClientDto create(ClientDto body) {
        var client = createClientUseCase.create(clientPresenter.toDomain(body));
        return clientPresenter.toDto(client);
    }

}
