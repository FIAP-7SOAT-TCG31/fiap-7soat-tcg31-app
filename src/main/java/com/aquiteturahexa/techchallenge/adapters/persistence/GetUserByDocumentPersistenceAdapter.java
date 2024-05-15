package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.UserMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.UserRepository;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.out.GetUserByDocumentPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
public class GetUserByDocumentPersistenceAdapter implements GetUserByDocumentPortOut {

    private final UserRepository userRepository;

    @Override
    public Optional<User> find(String cpf) {
        var userEntity = userRepository.findByCpf(cpf);
        return Optional.ofNullable(UserMapper.toDomain(userEntity));
    }
}
