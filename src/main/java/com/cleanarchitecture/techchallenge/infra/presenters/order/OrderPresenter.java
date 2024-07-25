package com.cleanarchitecture.techchallenge.infra.presenters.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.order.OrderDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.order.ResponseFollowupDto;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ComboPresenter;
import com.cleanarchitecture.techchallenge.infra.presenters.payment.PaymentPresenter;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.Objects.isNull;

public class OrderPresenter {

    private static OrderPresenter orderPresenter;

    private OrderPresenter() {
    }

    public static OrderPresenter getInstance() {
        if (orderPresenter == null) {
            orderPresenter = new OrderPresenter();
        }

        return orderPresenter;
    }

    public ResponseFollowupDto toFollowUpDto(Order order) {

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

    public List<OrderDto> toDto(List<Order> orders) {
        return orders == null || orders.isEmpty()
                ? List.of()
                : orders
                .stream()
                .map(this::toDto)
                .toList();
    }

    public OrderDto toDto(Order order) {
        return order == null
                ? null
                : OrderDto.builder()
                .withId(order.getId())
                .withRequestedAt(order.getRequestedAt() == null ? null : DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.systemDefault()).format(order.getRequestedAt()))
                .withUpdatedAt(order.getUpdatedAt() == null ? null : DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(ZoneId.systemDefault()).format(order.getUpdatedAt()))
                .withAmount(order.getAmount() == null ? BigDecimal.ZERO : order.getAmount())
                .withRequester(ClientPresenter.getInstance().toDto(order.getRequester()))
                .withCombo(ComboPresenter.getInstance().toDto(order.getCombo()))
                .withStatus(order.getStatus().name())
                .withPayment(PaymentPresenter.getInstance().toDto(order.getPayment()))
                .build();
    }
}
