package com.aquiteturahexa.techchallenge.core.model;

import java.util.List;

public class User {

    private String name;
    private Email email;
    private String username;
    private String password;
    private List<String> roles;

    public User() {
    }

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

    public List<String> getRoles() {
        return roles;
    }
}
