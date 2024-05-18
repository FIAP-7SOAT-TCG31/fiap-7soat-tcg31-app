package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.UserMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.UserRepository;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetUserByUserNamePersistenceAdapter implements GetUserPortOut {

    private final UserRepository userRepository;

    @Override
    public Optional<User> get(String username) {

        var userEntity = userRepository.findByUsername(username);
        return Optional.ofNullable(UserMapper.toDomain(userEntity));
    }
}
