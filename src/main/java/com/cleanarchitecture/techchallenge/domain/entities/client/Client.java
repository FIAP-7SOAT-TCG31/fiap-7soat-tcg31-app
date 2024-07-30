package com.cleanarchitecture.techchallenge.domain.entities.client;

import com.cleanarchitecture.techchallenge.domain.entities.Cpf;
import com.cleanarchitecture.techchallenge.domain.entities.Email;

public class Client {
    private Long id;
    private Cpf cpf;
    private String name;
    private Email email;

    public Client() {

    }

    public Client(Long id, Cpf cpf, String name, Email email) {
        this.id = id;
        this.cpf = cpf;
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }
}
