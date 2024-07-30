package com.cleanarchitecture.techchallenge.infra.dataproviders.user;

import com.cleanarchitecture.techchallenge.application.gateways.CreateUserGateway;
import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import com.cleanarchitecture.techchallenge.persistence.entities.UserEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateUserPersistenceAdapter implements CreateUserGateway {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntity.toEntity(user);
        return UserEntity.toDomain(userJpaRepository.save(Objects.requireNonNull(userEntity)));
    }
}
