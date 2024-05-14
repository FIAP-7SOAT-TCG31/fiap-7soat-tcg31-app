package com.aquiteturahexa.techchallenge.core.service;


import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.ports.in.GetOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GetOrderByIdPortOut;

import java.util.Optional;

public class GetOrderService implements GetOrderPortIn {

    private final GetOrderByIdPortOut getOrderByIdPortOut;

    public GetOrderService(GetOrderByIdPortOut getOrderByIdPortOut) {
        this.getOrderByIdPortOut = getOrderByIdPortOut;
    }

    @Override
    public Optional<Order> get(String orderId) {
        return getOrderByIdPortOut.get(orderId);
    }
}
