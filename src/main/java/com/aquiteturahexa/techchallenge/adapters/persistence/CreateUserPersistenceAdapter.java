package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.UserMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.UserRepository;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateUserPorOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CreateUserPersistenceAdapter implements CreateUserPorOut {

    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        return UserMapper.toDomain(userRepository.save(Objects.requireNonNull(userEntity)));
    }
}
