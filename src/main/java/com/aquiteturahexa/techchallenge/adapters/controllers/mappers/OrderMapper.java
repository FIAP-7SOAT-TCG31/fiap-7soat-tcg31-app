package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.OrderDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ResponseFollowupDto;
import com.aquiteturahexa.techchallenge.core.model.Order;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static java.util.Objects.isNull;

public class OrderMapper {

    public static ResponseFollowupDto toFollowUpDto(Order order) {

        var duration = Duration.between(order.getUpdatedAt(), Instant.now());

        return ResponseFollowupDto
                .builder()
                .withOrderId(String.format("%06d", order.getId()))
                .withAmount(order.getAmount())
                .withName(isNull(order.getRequester()) ? null : order.getRequester().getName())
                .withStatus(order.getStatus().name())
                .withWaitingTime(String.format("%02d:%02d", duration.toMinutesPart(), duration.toSecondsPart()))
                .build();
    }

    public static List<OrderDto> toDto(List<Order> orders) {
        return orders == null || orders.isEmpty()
                ? List.of()
                : orders
                .stream()
                .map(OrderMapper::toDto)
                .toList();
    }

    public static OrderDto toDto(Order order) {
        return OrderDto.builder()
                .withId(order.getId())
                .withAmount(order.getAmount())
                .withRequester(ClientMapper.toDto(order.getRequester()))
                .withCombo(ComboMapper.toDto(order.getCombo()))
                .withStatus(order.getStatus().name())
                .build();
    }
}
