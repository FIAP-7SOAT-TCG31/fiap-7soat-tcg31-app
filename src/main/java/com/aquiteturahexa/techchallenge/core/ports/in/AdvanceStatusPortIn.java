package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Order;

public interface AdvanceStatusPortIn {

    Order advance(Order order);
}
