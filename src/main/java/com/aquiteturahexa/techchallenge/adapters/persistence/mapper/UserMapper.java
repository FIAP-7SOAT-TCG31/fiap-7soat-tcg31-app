package com.aquiteturahexa.techchallenge.adapters.persistence.mapper;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import com.aquiteturahexa.techchallenge.core.model.Email;
import com.aquiteturahexa.techchallenge.core.model.User;

import static java.util.Objects.isNull;

public class UserMapper {

    public static UserEntity toEntity(User user) {
        return isNull(user)
                ? null
                : UserEntity
                .builder()
                .withId(user.getId())
                .withUsername(user.getUsername())
                .withEmail(user.getEmail().getEmail())
                .withName(user.getName())
                .withPassword(user.getPassword())
                .withRole(user.getRole())
                .build();
    }

    public static User toDomain(UserEntity user) {
        return isNull(user)
                ? null
                : new User(
                user.getId(),
                user.getName(),
                new Email(user.getEmail()),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }
}
