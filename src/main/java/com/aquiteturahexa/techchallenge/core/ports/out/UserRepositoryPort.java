package com.aquiteturahexa.techchallenge.core.ports.out;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.User;

public interface UserRepositoryPort {
    User save(User user);

    List<User> findAll();

    User findByid(Long id);

    User updateUser(Long id, User user);

    void deleteByid(Long id);
}