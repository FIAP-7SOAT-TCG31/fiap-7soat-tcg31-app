package com.aquiteturahexa.techchallenge.core.ports;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.User;

public interface UserRepositoryPort {
    User save(User user);

    List<User> findAll();
}
