package com.aquiteturahexa.techchallenge.core.ports.out;


import com.aquiteturahexa.techchallenge.core.model.Payment;

public interface GeneratePaymentPortOut {

    Payment generate(Payment payment);

    boolean isType(Payment payment);
}
