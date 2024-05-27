package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.User;

public interface CreateUserPortIn {
    User create(User user);
}
