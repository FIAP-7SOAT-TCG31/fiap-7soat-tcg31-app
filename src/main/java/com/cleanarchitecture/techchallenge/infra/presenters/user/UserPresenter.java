package com.cleanarchitecture.techchallenge.infra.presenters.user;

import com.cleanarchitecture.techchallenge.api.rest.dtos.user.UserDto;
import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import com.cleanarchitecture.techchallenge.domain.factories.UserFactory;

public class UserPresenter {

    private static UserPresenter userPresenter;

    private UserPresenter() {
    }

    public static UserPresenter getInstance() {
        if (userPresenter == null) {
            userPresenter = new UserPresenter();
        }

        return userPresenter;
    }

    public User toDomain(UserDto user) {
        return UserFactory
                .getInstance()
                .createUserWithNameEmailUsernamePasswordRoles(
                        user.getName(),
                        user.getEmail(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRoles()
                );
    }

    public UserDto toDto(User user) {
        return user == null
                ? null
                : UserDto
                .builder()
                .withUsername(user.getUsername())
                .withEmail(user.getEmail().email())
                .withName(user.getName())
                .build();
    }
}
