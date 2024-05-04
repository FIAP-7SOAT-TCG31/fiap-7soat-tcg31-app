package com.aquiteturahexa.techchallenge.core.ports;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Order;

public interface OrderServicePort {
    Order saveOrder(Order order);

    List<Order> findAll();

    Order findById(Long id);

    Order updateOrder(Long id, Order order);

    Order updateStatus(Long id, Order order);
}
