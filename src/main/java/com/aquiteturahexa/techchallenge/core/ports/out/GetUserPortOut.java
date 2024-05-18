package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.User;

import java.util.Optional;

public interface GetUserPortOut {

    Optional<User> get(String username);
}
