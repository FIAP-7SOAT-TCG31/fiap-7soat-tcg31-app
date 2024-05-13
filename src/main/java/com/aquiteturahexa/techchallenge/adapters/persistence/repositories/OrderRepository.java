package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}