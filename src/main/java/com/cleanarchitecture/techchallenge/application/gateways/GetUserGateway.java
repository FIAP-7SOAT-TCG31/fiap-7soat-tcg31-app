package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;

import java.util.Optional;

public interface GetUserGateway {

    Optional<User> get(String username);
}
