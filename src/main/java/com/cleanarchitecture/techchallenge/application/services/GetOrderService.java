package com.cleanarchitecture.techchallenge.application.services;


import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.usecases.GetOrderUseCase;
import com.cleanarchitecture.techchallenge.application.gateways.GetOrderByIdGateway;

import java.util.Optional;

public class GetOrderService implements GetOrderUseCase {

    private final GetOrderByIdGateway getOrderByIdGateway;

    public GetOrderService(GetOrderByIdGateway getOrderByIdGateway) {
        this.getOrderByIdGateway = getOrderByIdGateway;
    }

    @Override
    public Optional<Order> get(String orderId) {
        return getOrderByIdGateway.get(orderId);
    }
}
