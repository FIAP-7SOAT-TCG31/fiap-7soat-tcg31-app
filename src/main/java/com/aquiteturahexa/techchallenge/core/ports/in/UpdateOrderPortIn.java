package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Combo;
import com.aquiteturahexa.techchallenge.core.model.Order;

public interface UpdateOrderPortIn {

    Order update(Order order, Combo combo);

}
