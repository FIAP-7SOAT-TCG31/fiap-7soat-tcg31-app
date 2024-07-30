package com.cleanarchitecture.techchallenge.application.gateways;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface UpdateOrderGateway {

    Order update(Order order);

}
