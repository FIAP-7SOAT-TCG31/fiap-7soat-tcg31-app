package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.UserDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.UserMapper;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.UserServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;

    @PostMapping()
    public User creatUser(@RequestBody UserDto user) {

        return userServicePort.saveUser(UserMapper.toDomain(user));
    }

    @GetMapping()
    public List<User> findAll() {

        return userServicePort.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {

        return userServicePort.findById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return userServicePort.updateUser(id, UserMapper.toDomain(user));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        userServicePort.deleteById(id);
    }

}
