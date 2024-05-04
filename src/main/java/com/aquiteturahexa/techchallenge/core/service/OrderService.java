package com.aquiteturahexa.techchallenge.core.service;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.ports.OrderRepositoryPort;
import com.aquiteturahexa.techchallenge.core.ports.OrderServicePort;

public class OrderService implements OrderServicePort {

    public final OrderRepositoryPort orderRepositoryPort;

    public OrderService(OrderRepositoryPort orderRepositoryPort) {
        this.orderRepositoryPort = orderRepositoryPort;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepositoryPort.saveOrder(order);
    }

    @Override
    public List<Order> findAll() {
        return orderRepositoryPort.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepositoryPort.findById(id);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return orderRepositoryPort.updateOrder(id, order);
    }

    @Override
    public Order updateStatus(Long id, Order order) {
        return orderRepositoryPort.updateStatus(id, order);
    }
}
