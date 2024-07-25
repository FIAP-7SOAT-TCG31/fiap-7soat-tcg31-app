package com.cleanarchitecture.techchallenge.infra.gateways.order;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

import java.util.Optional;

public interface GetOrderByIdGateway {

    Optional<Order> get(String orderId);
}
