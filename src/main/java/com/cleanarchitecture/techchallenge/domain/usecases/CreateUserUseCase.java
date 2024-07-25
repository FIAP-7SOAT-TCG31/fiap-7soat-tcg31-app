package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;

public interface CreateUserUseCase {
    User create(User user);
}
