package com.aquiteturahexa.techchallenge.core.service;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.out.UserRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.in.UserServicePort;

public class UserService implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {

        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public List<User> findAll() {
        return userRepositoryPort.findAll();
    }

    @Override
    public User saveUser(User user) {

        return userRepositoryPort.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepositoryPort.findByid(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        return userRepositoryPort.updateUser(id, user);
    }

    @Override
    public void deleteById(Long id) {
        userRepositoryPort.deleteByid(id);
    }

}
