package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ItemDto;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.model.ItemType;

import java.util.List;

public class ItemMapper {

    public static List<Item> toDomain(List<ItemDto> items) {
        return items == null || items.isEmpty()
                ? List.of()
                : items
                .stream()
                .map(ItemMapper::toDomain)
                .toList();
    }

    public static Item toDomain(ItemDto item) {
        return new Item(
                item.getId(),
                item.getName(),
                ItemType.valueOf(item.getType()),
                item.getPrice(),
                item.getQuantity());
    }

    public static List<ItemDto> toDto(List<Item> items) {
        return items == null || items.isEmpty()
                ? List.of()
                : items
                .stream()
                .map(ItemMapper::toDto)
                .toList();
    }

    public static ItemDto toDto(Item item) {
        return ItemDto
                .builder()
                .withId(item.getId())
                .withName(item.getName())
                .withPrice(item.getPrice())
                .withType(item.getType().name())
                .withQuantity(item.getQuantity())
                .build();
    }
}
