package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;

public interface UpdateOrderUseCase {

    Order update(Order order, Combo combo);

}
