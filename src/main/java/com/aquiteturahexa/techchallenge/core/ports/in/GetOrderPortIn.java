package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Order;

import java.util.Optional;

public interface GetOrderPortIn {

    Optional<Order> get(String orderId);
}
