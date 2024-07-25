package com.cleanarchitecture.techchallenge.infra.gateways.user;

import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import com.cleanarchitecture.techchallenge.persistence.entities.UserEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetUserByUserNamePersistenceAdapter implements GetUserGateway {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> get(String username) {

        var userEntity = userJpaRepository.findByUsername(username);
        return userEntity.map(UserEntity::toDomain);
    }
}
