package com.cleanarchitecture.techchallenge.infra.presenters.payment;

import com.cleanarchitecture.techchallenge.api.rest.dtos.payment.PaymentDto;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

import java.util.Map;

public class PaymentMapper {

    public static PaymentDto toDto(Payment payment) {
        return payment == null
                ? null
                : PaymentDto
                .builder()
                .withType(payment.getType())
                .withPaymentDetails(Map.of(payment.getType(), payment.getPaymentDetails().get(0)))
                .build();
    }
}
