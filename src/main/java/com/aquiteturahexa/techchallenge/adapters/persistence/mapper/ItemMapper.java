package com.aquiteturahexa.techchallenge.adapters.persistence.mapper;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ItemEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderItemEntity;
import com.aquiteturahexa.techchallenge.core.model.Combo;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.model.ItemType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {

    public static Combo toDomain(List<OrderItemEntity> itens) {
        var itemList = itens == null || itens.isEmpty()
                ? new ArrayList<Item>()
                : itens
                .stream()
                .map(item ->
                        new Item(
                                item.getItem().getId(),
                                item.getItem().getName(),
                                ItemType.valueOf(item.getItem().getType()),
                                item.getItem().getPrice(),
                                item.getQuantity()
                        )
                )
                .collect(Collectors.toCollection(ArrayList::new));

        return new Combo(itemList);
    }

    public static List<OrderItemEntity> toEntity(Combo combo) {
        return combo.getItems() == null || combo.getItems().isEmpty()
                ? List.of()
                : combo.getItems()
                .stream()
                .map(item -> OrderItemEntity
                        .builder()
                        .withItem(
                                ItemEntity
                                        .builder()
                                        .withId(item.getId())
                                        .withName(item.getName())
                                        .withPrice(item.getPrice())
                                        .withType(item.getType().name())
                                        .build())
                        .withQuantity(item.getQuantity())
                        .build()
                )
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static Item toDomain(ItemEntity item) {
        return new Item(item.getId(), item.getName(), ItemType.valueOf(item.getType()), item.getPrice(), null);
    }

    public static ItemEntity toEntity(Item item) {
        return ItemEntity
                .builder()
                .withId(item.getId())
                .withName(item.getName())
                .withPrice(item.getPrice())
                .withType(item.getType().name())
                .build();
    }
}
