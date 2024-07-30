package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;

public interface CreateUserGateway {
    User save(User user);
}
