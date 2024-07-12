package com.cleanarchitecture.techchallenge.infra.gateways.order;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface UpdateOrderGateway {

    Order update(Order order);

}
