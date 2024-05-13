package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.UserDto;
import com.aquiteturahexa.techchallenge.core.model.User;

import static java.util.Objects.isNull;

public class UserMapper {

    public static User toDomain(UserDto user) {
        return isNull(user)
                ? null
                : new User(user.getId(), Long.valueOf(user.getCpf()), user.getName(), user.getEmail());
    }
}
