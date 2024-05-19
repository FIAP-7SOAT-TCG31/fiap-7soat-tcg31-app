package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.GetUserPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserPortOut;

import java.util.Optional;

public class GetUserService implements GetUserPortIn {

    private final GetUserPortOut getUserPortOut;

    public GetUserService(GetUserPortOut getUserPortOut) {
        this.getUserPortOut = getUserPortOut;
    }

    @Override
    public Optional<User> getUser(String username) {
        return getUserPortOut.get(username);
    }

    @Override
    public Optional<User> getUser(String username, String password) {

        var user = getUser(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }

        return Optional.empty();
    }
}
