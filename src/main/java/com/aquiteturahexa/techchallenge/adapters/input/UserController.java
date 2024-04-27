package com.aquiteturahexa.techchallenge.adapters.input;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.application.UserServices;
import com.aquiteturahexa.techchallenge.core.model.User;

@RestController
@RequestMapping("/")
public class UserController {

    private UserServices userservices;

    @GetMapping("/ola")
    public String testeTeste() {
        return "Ola imbecil";
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userservices.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userservices.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userservices.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userservices.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userservices.deleteUser(id);
    }
}
