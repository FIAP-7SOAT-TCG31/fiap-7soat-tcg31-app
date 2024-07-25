package com.cleanarchitecture.techchallenge.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cleanarchitecture.techchallenge.persistence.entities.ClientEntity;

public interface ClientJpaRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByCpf(String cpf);
}