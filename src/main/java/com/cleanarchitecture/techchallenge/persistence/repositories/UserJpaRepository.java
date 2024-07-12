package com.cleanarchitecture.techchallenge.persistence.repositories;

import com.cleanarchitecture.techchallenge.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, String>, JpaSpecificationExecutor<UserEntity> {

    Optional<UserEntity> findByUsername(String username);
}
