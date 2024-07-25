package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import com.cleanarchitecture.techchallenge.domain.usecases.GetUserUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.user.EncodePasswordGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.user.GetUserGateway;

import java.util.Optional;

public class GetUserService implements GetUserUseCase {

    private final GetUserGateway getUserGateway;
    private final EncodePasswordGateway encodePasswordGateway;

    public GetUserService(GetUserGateway getUserGateway, EncodePasswordGateway encodePasswordGateway) {
        this.getUserGateway = getUserGateway;
        this.encodePasswordGateway = encodePasswordGateway;
    }

    @Override
    public Optional<User> getUser(String username) {
        return getUserGateway.get(username);
    }

    @Override
    public Optional<User> getUser(String username, String password) {

        var user = getUser(username);

        if (user.isPresent() && encodePasswordGateway.matches(password, user.get().getPassword())) {
            return user;
        }

        return Optional.empty();
    }
}
