package com.aquiteturahexa.techchallenge.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquiteturahexa.techchallenge.adapters.output.UserRepository;
import com.aquiteturahexa.techchallenge.core.model.User;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    /*
     * ....
     */
}
