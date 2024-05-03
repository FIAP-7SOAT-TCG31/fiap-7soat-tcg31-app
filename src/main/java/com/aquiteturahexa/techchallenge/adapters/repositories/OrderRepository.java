package com.aquiteturahexa.techchallenge.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquiteturahexa.techchallenge.adapters.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}