package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Payment;
import com.aquiteturahexa.techchallenge.core.ports.in.GeneratePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GeneratePaymentPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;
import java.util.HashMap;


public class GeneratePaymentService implements GeneratePaymentPortIn {

    private final GeneratePaymentPortOut generatePaymentPortOut;
    private final UpdateOrderPortOut updateOrderPortOut;

    public GeneratePaymentService(GeneratePaymentPortOut generatePaymentPortOut, UpdateOrderPortOut updateOrderPortOut) {
        this.generatePaymentPortOut = generatePaymentPortOut;
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Payment generate(Order order) {

        var payment = new Payment("QR_CODE", order, new HashMap<>());
        this.generatePaymentPortOut.generate(payment);

        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        this.updateOrderPortOut.update(order);

        return payment;
    }
}
