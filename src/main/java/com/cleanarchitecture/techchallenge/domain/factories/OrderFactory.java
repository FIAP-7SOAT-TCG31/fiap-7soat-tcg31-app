package com.cleanarchitecture.techchallenge.domain.factories;


import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;

import java.math.BigDecimal;
import java.time.Instant;

public class OrderFactory {
    private static OrderFactory instance;

    private OrderFactory() {
    }

    public static OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();
        }

        return instance;
    }

    public Order createOrderWithRequesterComboAmountStatus(Client requester,
                                                           Combo combo,
                                                           BigDecimal amount,
                                                           Status status) {
        return new Order(null, requester, combo, Instant.now(), null, amount, status, null);
    }
}
