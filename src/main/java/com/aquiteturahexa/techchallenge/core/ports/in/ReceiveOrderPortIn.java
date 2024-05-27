package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Order;

public interface ReceiveOrderPortIn {

    Order receive(Order order);
}
