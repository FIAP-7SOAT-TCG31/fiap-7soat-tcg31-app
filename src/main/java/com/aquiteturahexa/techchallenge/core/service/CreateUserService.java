package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateUserPortIn;
import com.aquiteturahexa.techchallenge.core.ports.in.EncodePasswordPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateUserPorOut;

public class CreateUserService implements CreateUserPortIn {

    private final CreateUserPorOut createUserPorOut;
    private final EncodePasswordPortOut encodePasswordPortOut;

    public CreateUserService(CreateUserPorOut createUserPorOut, EncodePasswordPortOut encodePasswordPortOut) {
        this.createUserPorOut = createUserPorOut;
        this.encodePasswordPortOut = encodePasswordPortOut;
    }

    @Override
    public User create(User user) {
        user.setPassword(encodePasswordPortOut.encode(user.getPassword()));
        return createUserPorOut.save(user);
    }
}
