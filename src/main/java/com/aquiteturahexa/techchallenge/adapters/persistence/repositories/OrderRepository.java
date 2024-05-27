package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>, JpaSpecificationExecutor<OrderEntity> {
}