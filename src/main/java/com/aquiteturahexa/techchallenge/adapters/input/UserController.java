package com.aquiteturahexa.techchallenge.adapters.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.application.UserServices;
import com.aquiteturahexa.techchallenge.core.model.User;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserServices userservices;

    @GetMapping("/ola")
    public String testeTeste() {
        return "Ola imbecil";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userservices.getAllUsers();
    }
}
