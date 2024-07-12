package com.cleanarchitecture.techchallenge.domain.usecases;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

public interface GeneratePaymentUseCase {

    Payment generate(Order order, String paymentType);
}
