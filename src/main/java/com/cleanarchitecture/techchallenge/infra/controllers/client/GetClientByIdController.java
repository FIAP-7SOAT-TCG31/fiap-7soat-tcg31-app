package com.cleanarchitecture.techchallenge.infra.controllers.client;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByIdUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetClientByIdController {

    private final GetClientByIdUseCase getClientByIdUseCase;
    private final ClientPresenter clientPresenter;

    public GetClientByIdController(GetClientByIdUseCase getClientByIdUseCase) {
        this.getClientByIdUseCase = getClientByIdUseCase;
        this.clientPresenter = ClientPresenter.getInstance();
    }

    public Optional<ClientDto> get(Long id) {
        var client = getClientByIdUseCase.find(id);
        return client.map(clientPresenter::toDto);
    }
}
