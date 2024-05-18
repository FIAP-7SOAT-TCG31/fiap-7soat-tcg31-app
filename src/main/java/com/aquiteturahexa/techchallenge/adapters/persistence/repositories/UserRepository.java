package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    UserEntity findByUsername(String username);
}
