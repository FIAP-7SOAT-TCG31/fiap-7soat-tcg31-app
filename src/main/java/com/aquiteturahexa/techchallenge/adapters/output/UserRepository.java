package com.aquiteturahexa.techchallenge.adapters.output;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.User;

public interface UserRepository/* implements algo */ {

    public List<User> findAll();

    public User findById(Long id);

    public User save(User user);

    public void deleteById(Long id);
}