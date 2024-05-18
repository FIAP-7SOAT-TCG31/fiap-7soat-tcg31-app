package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.UserDto;
import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import com.aquiteturahexa.techchallenge.core.model.User;

import static java.util.Objects.isNull;

public class UserMapper {

    public static User toDomain(UserDto userDto) {
        return isNull(userDto)
                ? null
                : new User(userDto.getId(), Long.valueOf(userDto.getCpf()), userDto.getName(),
                        userDto.getEmail());
    }

    public static UserEntity toEntity(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toEntity'");
    }
}
