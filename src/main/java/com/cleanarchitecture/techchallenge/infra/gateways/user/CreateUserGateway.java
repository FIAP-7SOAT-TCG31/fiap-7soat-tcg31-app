package com.cleanarchitecture.techchallenge.infra.gateways.user;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;

public interface CreateUserGateway {
    User save(User user);
}
