package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByIdPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetClientByIdPortOut;

import java.util.Optional;

public class GetClientByIdService implements GetClientByIdPortIn {

    private final GetClientByIdPortOut getClientByIdPortOut;

    public GetClientByIdService(GetClientByIdPortOut getClientByIdPortOut) {
        this.getClientByIdPortOut = getClientByIdPortOut;
    }

    @Override
    public Optional<Client> find(Long id) {
        return getClientByIdPortOut.find(id);
    }
}
