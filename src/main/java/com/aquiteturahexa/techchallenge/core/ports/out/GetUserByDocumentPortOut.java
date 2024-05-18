package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.User;

import java.util.Optional;

public interface GetUserByDocumentPortOut {

    Optional<User> find(String cpf);
}
