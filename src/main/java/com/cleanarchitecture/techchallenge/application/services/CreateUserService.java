package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateUserUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.user.CreateUserGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.user.EncodePasswordGateway;

public class CreateUserService implements CreateUserUseCase {

    private final CreateUserGateway createUserGateway;
    private final EncodePasswordGateway encodePasswordGateway;

    public CreateUserService(CreateUserGateway createUserGateway, EncodePasswordGateway encodePasswordGateway) {
        this.createUserGateway = createUserGateway;
        this.encodePasswordGateway = encodePasswordGateway;
    }

    @Override
    public User create(User user) {
        user.setPassword(encodePasswordGateway.encode(user.getPassword()));
        return createUserGateway.save(user);
    }
}
