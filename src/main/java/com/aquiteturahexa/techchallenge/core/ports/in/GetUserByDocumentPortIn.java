package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.User;

import java.util.Optional;

public interface GetUserByDocumentPortIn {

    Optional<User> find(String cpf);
}
