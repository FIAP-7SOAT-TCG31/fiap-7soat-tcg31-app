package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByCpf(String cpf);
}