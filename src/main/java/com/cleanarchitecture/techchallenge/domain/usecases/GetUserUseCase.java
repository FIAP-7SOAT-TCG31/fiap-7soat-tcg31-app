package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;

import java.util.Optional;

public interface GetUserUseCase {

    Optional<User> getUser(String username);

    Optional<User> getUser(String username, String password);
}
