package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByCpf(String cpf);
}