package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface EffecitvePaymentUseCase {

    Order pay(Order order);
}
