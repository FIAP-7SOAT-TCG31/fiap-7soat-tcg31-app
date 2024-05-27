package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByDocumentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByDocumentPortOut;

import java.util.Optional;

public class GetClientByDocumentService implements GetClientByDocumentPortIn {

    private final GetClientByDocumentPortOut getClientByDocumentPortOut;

    public GetClientByDocumentService(GetClientByDocumentPortOut getClientByDocumentPortOut) {
        this.getClientByDocumentPortOut = getClientByDocumentPortOut;
    }

    @Override
    public Optional<Client> find(String cpf) {
        return getClientByDocumentPortOut.find(cpf);
    }
}
