package com.cleanarchitecture.techchallenge.domain.entities.user;

import com.cleanarchitecture.techchallenge.domain.entities.Email;

import java.util.List;

public class User {

    private final String name;
    private final Email email;
    private final String username;
    private String password;
    private final List<String> roles;

    public User(String name, Email email, String username, String password, List<String> roles) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }
}
