package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.EncodePasswordPortOut;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserPortOut;

import java.util.Optional;

public class GetUserService implements GetUserPortIn {

    private final GetUserPortOut getUserPortOut;
    private final EncodePasswordPortOut encodePasswordPortOut;

    public GetUserService(GetUserPortOut getUserPortOut, EncodePasswordPortOut encodePasswordPortOut) {
        this.getUserPortOut = getUserPortOut;
        this.encodePasswordPortOut = encodePasswordPortOut;
    }

    @Override
    public Optional<User> getUser(String username) {
        return getUserPortOut.get(username);
    }

    @Override
    public Optional<User> getUser(String username, String password) {

        var user = getUser(username);

        if (user.isPresent() && encodePasswordPortOut.matches(password, user.get().getPassword())) {
            return user;
        }

        return Optional.empty();
    }
}
