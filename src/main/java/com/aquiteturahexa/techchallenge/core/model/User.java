package com.aquiteturahexa.techchallenge.core.model;

public class User {

    private Long id;
    private String name;
    private Email email;
    private String username;
    private String password;
    private String role;

    public User() {
    }

    public User(Long id, String name, Email email, String username, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
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

    public String getRole() {
        return role;
    }
}
