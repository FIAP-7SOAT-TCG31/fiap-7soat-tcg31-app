package com.cleanarchitecture.techchallenge.infra.presenters.payment;

import com.cleanarchitecture.techchallenge.api.rest.dtos.payment.PaymentDto;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class PaymentPresenter {

    private static PaymentPresenter paymentPresenter;

    private PaymentPresenter() {
    }

    public static PaymentPresenter getInstance() {
        if (paymentPresenter == null) {
            paymentPresenter = new PaymentPresenter();
        }

        return paymentPresenter;
    }

    public PaymentDto toDto(Payment payment) {
        return payment == null
                ? null
                : PaymentDto
                .builder()
                .withType(payment.getType())
                .withPaid(payment.getPaid())
                .withPaidAt(payment.getPaidAt() == null ? null : DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.systemDefault()).format(payment.getPaidAt()))
                .withPaymentDetails(payment.getPaymentDetails().isEmpty() ? null : Map.of(payment.getType(), payment.getPaymentDetails().get(0)))
                .build();
    }
}
