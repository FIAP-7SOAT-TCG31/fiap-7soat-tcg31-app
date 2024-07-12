package com.cleanarchitecture.techchallenge.infra.presenters.user;

import com.cleanarchitecture.techchallenge.api.rest.dtos.user.UserDto;
import com.cleanarchitecture.techchallenge.domain.entities.Email;
import com.cleanarchitecture.techchallenge.domain.entities.user.User;

public class UserMapper {

    public static User toDomain(UserDto user) {
        return new User(user.getName(), new Email(user.getEmail()), user.getUsername(), user.getPassword(), user.getRoles());
    }

    public static UserDto toDto(User user) {
        return UserDto
                .builder()
                .withUsername(user.getUsername())
                .withEmail(user.getEmail().email())
                .withName(user.getName())
                .build();
    }
}
