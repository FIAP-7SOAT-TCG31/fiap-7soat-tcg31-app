package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.UserDto;
import com.aquiteturahexa.techchallenge.core.model.Email;
import com.aquiteturahexa.techchallenge.core.model.User;

public class UserMapper {

    public static User toDomain(UserDto user) {
        return new User(user.getName(), new Email(user.getEmail()), user.getUsername(), user.getPassword(), user.getRoles());
    }

    public static UserDto toDto(User user) {
        return UserDto
                .builder()
                .withUsername(user.getUsername())
                .withEmail(user.getEmail().getEmail())
                .withName(user.getName())
                .build();
    }
}
