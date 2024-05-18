package com.aquiteturahexa.techchallenge.adapters.persistence.mapper;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import com.aquiteturahexa.techchallenge.core.model.User;

import static java.util.Objects.isNull;

public class UserMapper {

    public static UserEntity toEntity(User requester) {
        return isNull(requester)
                ? null
                : UserEntity
                        .builder()
                        .withId(requester.getId())
                        .withCpf(String.valueOf(requester.getCPF()))
                        .withName(requester.getName())
                        .withEmail(requester.getEmail())
                        .build();
    }

    public static User toDomain(UserEntity requester) {
        return isNull(requester)
                ? null
                : new User(requester.getId(), Long.valueOf(requester.getCpf()), requester.getName(),
                        requester.getEmail());
    }
}
