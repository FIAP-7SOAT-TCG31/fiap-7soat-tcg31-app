package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.ports.OrderRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.OrderServicePort;

public class OrderService implements OrderServicePort {

    public final OrderRepositoryPort orderRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }
}
