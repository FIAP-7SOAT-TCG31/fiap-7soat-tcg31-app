package com.aquiteturahexa.techchallenge.adapters.persistence.mapper;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderEntity;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;

import java.time.ZoneId;

import static java.util.Objects.isNull;

public class OrderMapper {

    public static OrderEntity toEntity(Order order) {
        return OrderEntity
                .builder()
                .withId(order.getId())
                .withRequestedAt(order.getRequestedAt().atZone(ZoneId.systemDefault()))
                .withStatus(order.getStatus().name())
                .withAmount(order.getAmount())
                .withRequester(UserMapper.toEntity(order.getRequester()))
                .withUpdatedAt(isNull(order.getUpdatedAt()) ? null : order.getUpdatedAt().atZone(ZoneId.systemDefault()))
                .withItens(ItemMapper.toEntity(order.getCombo()))
                .build();
    }

    public static Order toDomain(OrderEntity order) {
        return new Order(order.getId(), UserMapper.toDomain(order.getRequester()), ItemMapper.toDomain(order.getItens()), order.getRequestedAt().toInstant(), isNull(order.getUpdatedAt()) ? null : order.getUpdatedAt().toInstant(), order.getAmount(), Status.valueOf(order.getStatus()));
    }
}
