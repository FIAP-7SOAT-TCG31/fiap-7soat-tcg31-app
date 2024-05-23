package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.User;

public interface CreateUserPorOut {
    User save(User user);
}
