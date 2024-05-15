package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserByDocumentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserByDocumentPortOut;

import java.util.Optional;

public class GetUserByDocumentService implements GetUserByDocumentPortIn {

    private final GetUserByDocumentPortOut getUserByDocumentPortOut;

    public GetUserByDocumentService(GetUserByDocumentPortOut getUserByDocumentPortOut) {
        this.getUserByDocumentPortOut = getUserByDocumentPortOut;
    }

    @Override
    public Optional<User> find(String cpf) {
        return getUserByDocumentPortOut.find(cpf);
    }
}
