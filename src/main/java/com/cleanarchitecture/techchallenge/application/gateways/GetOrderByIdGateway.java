package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

import java.util.Optional;

public interface GetOrderByIdGateway {

    Optional<Order> get(String orderId);
}
