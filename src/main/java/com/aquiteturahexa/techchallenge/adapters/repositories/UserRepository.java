package com.aquiteturahexa.techchallenge.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquiteturahexa.techchallenge.adapters.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}