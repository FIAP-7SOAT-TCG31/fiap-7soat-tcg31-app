package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.UserMapper;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.out.UserRepositoryPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public User save(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        return UserMapper.toDomain(userRepository.save(entity));
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> list = userRepository.findAll();

        return list
                .stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public User findByid(Long id) {
        Optional<UserEntity> obj = userRepository.findById(id);

        return obj.map(UserMapper::toDomain)
                .orElse(null);

    }

    @Override
    public User updateUser(Long id, User updateUser) {
        User existuser = findByid(id);
        existuser.setName(updateUser.getName());
        existuser.setEmail(updateUser.getEmail());
        return save(existuser);
    }

    @Override
    public void deleteByid(Long id) {

        userRepository.deleteById(id);
    }

}
