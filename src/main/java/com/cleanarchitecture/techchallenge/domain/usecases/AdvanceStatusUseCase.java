package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface AdvanceStatusUseCase {

    Order advance(Order order);
}
