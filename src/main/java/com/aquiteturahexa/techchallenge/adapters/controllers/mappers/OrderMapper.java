package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ResponseFollowupDto;
import com.aquiteturahexa.techchallenge.core.model.Order;

import java.time.Duration;
import java.time.Instant;

public class OrderMapper {

    public static ResponseFollowupDto toDto(Order order) {

        var duration = Duration.between(order.getUpdatedAt(), Instant.now());

        return ResponseFollowupDto
                .builder()
                .withOrderId(String.format("%05d", order.getId()))
                .withAmount(order.getAmount())
                .withStatus(order.getStatus().name())
                .withWaitingTime(String.format("%02d:%02d", duration.toMinutesPart(), duration.toSecondsPart()))
                .build();
    }

}
