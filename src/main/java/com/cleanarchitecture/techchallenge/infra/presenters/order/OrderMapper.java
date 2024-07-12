package com.cleanarchitecture.techchallenge.infra.presenters.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientMapper;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ComboMapper;

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
        return order == null
                ? null
                : OrderDto.builder()
                .withId(order.getId())
                .withAmount(order.getAmount())
                .withRequester(ClientMapper.toDto(order.getRequester()))
                .withCombo(ComboMapper.toDto(order.getCombo()))
                .withStatus(order.getStatus().name())
                .build();
    }
}
