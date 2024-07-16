package com.cleanarchitecture.techchallenge.application.services;

import com.cleanarchitecture.techchallenge.application.exceptions.PaymentNotValidException;
import com.cleanarchitecture.techchallenge.application.validation.PaymentExistsHandler;
import com.cleanarchitecture.techchallenge.application.validation.PaymentValidationHandler;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;
import com.cleanarchitecture.techchallenge.domain.factories.PaymentFactory;
import com.cleanarchitecture.techchallenge.domain.usecases.GeneratePaymentUseCase;
import com.cleanarchitecture.techchallenge.infra.gateways.payment.GeneratePaymentGateway;
import com.cleanarchitecture.techchallenge.infra.gateways.order.UpdateOrderGateway;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;


public class GeneratePaymentService implements GeneratePaymentUseCase {

    private final List<GeneratePaymentGateway> generatePaymentGateway;
    private final UpdateOrderGateway updateOrderGateway;
    private final PaymentValidationHandler handlerChain;


    public GeneratePaymentService(List<GeneratePaymentGateway> generatePaymentGateway,
                                  UpdateOrderGateway updateOrderGateway,
                                  PaymentValidationHandler handlerChain) {
        this.generatePaymentGateway = generatePaymentGateway;
        this.updateOrderGateway = updateOrderGateway;
        this.handlerChain = handlerChain;
    }

    @Override
    public Payment generate(Order order, Client client, String paymentType) {

        handlerChain.handle(order, client, paymentType);

        var payment = order.getPayment() == null
                ? PaymentFactory.getInstance().createPayment(paymentType)
                : order.getPayment();

        var paymentGateway = this.generatePaymentGateway
                .stream()
                .filter(port -> port.isType(payment))
                .findAny()
                .orElseThrow(() -> new PaymentNotValidException(String.join(" ", "Payment", paymentType, "not valid")));

        paymentGateway.generate(payment, order);

        order.advance();
        order.setPayment(payment);
        this.updateOrderGateway.update(order);

        return payment;
    }
}
