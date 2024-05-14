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
                .map(item ->
                        new Item(
                                item.getId(),
                                item.getName(),
                                ItemType.valueOf(item.getType()),
                                item.getPrice(),
                                item.getQuantity()))
                .toList();
    }
}
