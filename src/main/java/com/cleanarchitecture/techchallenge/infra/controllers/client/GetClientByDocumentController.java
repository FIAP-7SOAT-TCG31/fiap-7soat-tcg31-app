package com.cleanarchitecture.techchallenge.infra.controllers.client;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByDocumentUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetClientByDocumentController {

    private final GetClientByDocumentUseCase getClientByDocumentUseCase;
    private final ClientPresenter clientPresenter;

    public GetClientByDocumentController(GetClientByDocumentUseCase getClientByDocumentUseCase) {
        this.getClientByDocumentUseCase = getClientByDocumentUseCase;
        this.clientPresenter = ClientPresenter.getInstance();
    }

    public Optional<ClientDto> get(String cpf) {
        var client = getClientByDocumentUseCase.find(cpf);
        return client.map(clientPresenter::toDto);
    }

}
