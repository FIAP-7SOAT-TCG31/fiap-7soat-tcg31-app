package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.Order;

import java.util.Optional;

public interface GetOrderByIdPortOut {

    Optional<Order> get(String orderId);
}
