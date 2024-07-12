package com.cleanarchitecture.techchallenge.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, Long>, JpaSpecificationExecutor<ItemEntity> {
}