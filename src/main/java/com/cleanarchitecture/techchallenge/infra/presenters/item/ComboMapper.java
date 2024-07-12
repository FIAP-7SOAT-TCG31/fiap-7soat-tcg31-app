package com.cleanarchitecture.techchallenge.infra.presenters.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ComboDto;
import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;

public class ComboMapper {

    public static Combo toDomain(ComboDto combo) {
        return combo == null
                ? null
                : new Combo(ItemMapper.toDomain(combo.getItems()));
    }

    public static ComboDto toDto(Combo combo) {
        return combo == null
                ? null
                : ComboDto
                .builder()
                .withItems(ItemMapper.toDto(combo.getItems()))
                .build();
    }
}
