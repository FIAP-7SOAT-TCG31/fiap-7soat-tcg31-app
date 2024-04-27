package com.aquiteturahexa.techchallenge.core.ports;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.User;

public interface UserServicePort {

    List<User> findAll();

    User saveUser(User user);
}