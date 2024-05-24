package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Order;

public interface EffecitvePaymentPortIn {

    Order pay(Order order);
}
