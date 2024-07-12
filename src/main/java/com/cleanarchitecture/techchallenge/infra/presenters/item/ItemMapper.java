package com.cleanarchitecture.techchallenge.infra.presenters.item;

import java.util.ArrayList;
import java.util.List;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;

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
        return item == null
                ? null
                : new Item(
                item.getId(),
                item.getName(),
                ItemType.valueOf(item.getType()),
                item.getPrice(),
                item.getQuantity(),
                item.getDescription(),
                item.getImages() == null || item.getImages().isEmpty() ? List.of() : new ArrayList<>(item.getImages()));
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
        return item == null
                ? null
                : ItemDto
                .builder()
                .withId(item.getId())
                .withName(item.getName())
                .withPrice(item.getPrice())
                .withType(item.getType().name())
                .withQuantity(item.getQuantity())
                .withDescription(item.getDescription())
                .withImages(item.getImages() == null || item.getImages().isEmpty() ? List.of() : item.getImages())
                .build();
    }
}
