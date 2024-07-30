package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

import java.util.Optional;

public interface GetOrderUseCase {

    Optional<Order> get(String orderId);
}
