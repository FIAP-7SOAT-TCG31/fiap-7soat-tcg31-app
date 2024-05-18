package com.aquiteturahexa.techchallenge.core.model;

public class Client {
    private Long id;
    private Long CPF;
    private String name;
    private String email;

    public Client() {

    }

    public Client(Long id, Long CPF, String name, String email) {
        this.id = id;
        this.CPF = CPF;
        this.name = name;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCPF() {
        return CPF;
    }

    public void setCPF(Long CPF) {
        this.CPF = CPF;
    }
}
