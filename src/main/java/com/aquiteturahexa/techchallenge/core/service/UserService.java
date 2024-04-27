package com.aquiteturahexa.techchallenge.core.service;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.UserRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.UserServicePort;

public class UserService implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {

        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> findAll() {
        return userRepositoryPort.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepositoryPort.save(user);
    }

}
