package com.cleanarchitecture.techchallenge.domain.factories;

import com.cleanarchitecture.techchallenge.domain.entities.Email;
import com.cleanarchitecture.techchallenge.domain.entities.user.User;

import java.util.List;

public class UserFactory {

    private static UserFactory instance;

    private UserFactory() {
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }

        return instance;
    }

    public User createUserWithNameEmailUsernamePasswordRoles(String name, String email, String username, String password, List<String> roles) {
        return new User(name, new Email(email), username, password, roles);
    }
}
