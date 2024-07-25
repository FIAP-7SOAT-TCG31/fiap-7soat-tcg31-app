package com.cleanarchitecture.techchallenge.infra.gateways.user;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;

import java.util.Optional;

public interface GetUserGateway {

    Optional<User> get(String username);
}
