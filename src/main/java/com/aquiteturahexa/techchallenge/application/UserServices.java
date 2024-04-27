package com.aquiteturahexa.techchallenge.application;

import java.util.List;

import com.aquiteturahexa.techchallenge.adapters.output.UserRepository;
import com.aquiteturahexa.techchallenge.core.model.User;

public class UserServices {

    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {

        return userRepository.findById(id);
    }

    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User existeUser = userRepository.findById(id);

        if (existeUser != null) {
            user.setId(id);
            return userRepository.save(user);
        }

        // Tratar retorno null
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
