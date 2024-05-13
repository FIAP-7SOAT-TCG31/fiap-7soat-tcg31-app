package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}