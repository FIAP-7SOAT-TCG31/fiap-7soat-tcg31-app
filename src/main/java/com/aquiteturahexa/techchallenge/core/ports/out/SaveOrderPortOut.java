package com.aquiteturahexa.techchallenge.core.ports.out;

import com.aquiteturahexa.techchallenge.core.model.Order;

public interface SaveOrderPortOut {

    Order create(Order order);
}
