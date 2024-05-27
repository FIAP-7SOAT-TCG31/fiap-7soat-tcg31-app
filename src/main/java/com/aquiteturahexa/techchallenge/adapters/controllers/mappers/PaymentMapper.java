package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.PaymentDto;
import com.aquiteturahexa.techchallenge.core.model.Payment;

import java.util.Map;

public class PaymentMapper {

    public static PaymentDto toDto(Payment payment) {
        return PaymentDto
                .builder()
                .withType(payment.getType())
                .withPaymentDetails(Map.of(payment.getType(), payment.getPaymentDetails().get("QR_CODE")))
                .build();
    }
}
