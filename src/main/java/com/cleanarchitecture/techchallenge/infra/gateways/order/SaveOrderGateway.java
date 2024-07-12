package com.cleanarchitecture.techchallenge.infra.gateways.order;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface SaveOrderGateway {

    Order create(Order order);
}
