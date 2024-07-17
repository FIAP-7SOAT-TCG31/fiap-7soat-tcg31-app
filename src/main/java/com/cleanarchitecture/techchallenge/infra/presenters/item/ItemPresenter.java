package com.cleanarchitecture.techchallenge.infra.presenters.item;

import java.util.ArrayList;
import java.util.List;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;
import com.cleanarchitecture.techchallenge.domain.factories.ItemFactory;

public class ItemPresenter {

    private static ItemPresenter itemPresenter;

    private ItemPresenter() {
    }

    public static ItemPresenter getInstance() {
        if (itemPresenter == null) {
            itemPresenter = new ItemPresenter();
        }

        return itemPresenter;
    }

    public List<Item> toDomain(List<ItemDto> items) {
        return items == null || items.isEmpty()
                ? List.of()
                : items
                .stream()
                .map(this::toDomain)
                .toList();
    }

    public Item toDomain(ItemDto item) {
        return item == null
                ? null
                : ItemFactory.getInstance().createItemWithIdNameTypePriceQuantityDescriptionImagesNote(
                item.getId(),
                item.getName(),
                ItemType.valueOf(item.getType()),
                item.getPrice(),
                item.getQuantity(),
                item.getDescription(),
                item.getImages() == null || item.getImages().isEmpty() ? null : new ArrayList<>(item.getImages()),
                item.getNote()
        );
    }

    public List<ItemDto> toDto(List<Item> items) {
        return items == null || items.isEmpty()
                ? List.of()
                : items
                .stream()
                .map(this::toDto)
                .toList();
    }

    public ItemDto toDto(Item item) {
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
                .withNote(item.getNote())
                .build();
    }
}
