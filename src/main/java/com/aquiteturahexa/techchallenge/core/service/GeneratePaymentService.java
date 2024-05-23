package com.aquiteturahexa.techchallenge.core.service;

import com.aquiteturahexa.techchallenge.core.exceptions.PaymentNotValidException;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Payment;
import com.aquiteturahexa.techchallenge.core.ports.in.GeneratePaymentPortIn;
import com.aquiteturahexa.techchallenge.core.ports.out.GeneratePaymentPortOut;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateOrderPortOut;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;


public class GeneratePaymentService implements GeneratePaymentPortIn {

    private final List<GeneratePaymentPortOut> generatePaymentPortOut;
    private final UpdateOrderPortOut updateOrderPortOut;

    public GeneratePaymentService(List<GeneratePaymentPortOut> generatePaymentPortOut, UpdateOrderPortOut updateOrderPortOut) {
        this.generatePaymentPortOut = generatePaymentPortOut;
        this.updateOrderPortOut = updateOrderPortOut;
    }

    @Override
    public Payment generate(Order order, String paymentType) {

        var payment = new Payment(paymentType, order, new HashMap<>());

        var paymentGateway = this.generatePaymentPortOut
                .stream()
                .filter(port -> port.isType(payment))
                .findAny()
                .orElseThrow(() -> new PaymentNotValidException("Payment ".concat(paymentType).concat(" not valid")));

        paymentGateway.generate(payment);

        order.setStatus(order.getStatus().advance());
        order.setUpdatedAt(Instant.now());
        this.updateOrderPortOut.update(order);

        return payment;
    }
}
