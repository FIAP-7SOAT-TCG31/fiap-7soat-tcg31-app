package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Combo;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.model.User;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateOrderPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.SaveOrderPort;

import java.time.Instant;

public class CreateOrderService implements CreateOrderPortIn {

    private final SaveOrderPort saveOrderPort;

    public CreateOrderService(SaveOrderPort saveOrderPort) {
        this.saveOrderPort = saveOrderPort;
    }

    @Override
    public Order create(Combo combo, User user) {
        var order = new Order(null, user, combo, Instant.now(), combo.calculate(), Status.CREATED);
        return saveOrderPort.create(order);
    }
}
