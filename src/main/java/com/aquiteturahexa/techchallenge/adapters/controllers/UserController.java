package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.UserServicePort;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;

    @PostMapping()
    public User creatUser(@RequestBody User user) {

        return userServicePort.saveUser(user);
    }

    @GetMapping()
    public List<User> findAll() {

        return userServicePort.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        return userServicePort.findById(id);
    }
    /*
     * @GetMapping("/ola")
     * public String testeTeste() {
     * return "Ola imbecil";
     * }
     */

}
