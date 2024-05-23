package com.aquiteturahexa.techchallenge.core.ports.in;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Payment;

public interface GeneratePaymentPortIn {

    Payment generate(Order order);
}
