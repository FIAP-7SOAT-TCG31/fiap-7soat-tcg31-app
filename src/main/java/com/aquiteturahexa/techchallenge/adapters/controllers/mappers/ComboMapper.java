package com.aquiteturahexa.techchallenge.adapters.controllers.mappers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ComboDto;
import com.aquiteturahexa.techchallenge.core.model.Combo;

import static java.util.Objects.isNull;

public class ComboMapper {

    public static Combo toDomain(ComboDto combo) {
        return isNull(combo)
                ? null
                : new Combo(ItemMapper.toDomain(combo.getItems()));
    }

    public static ComboDto toDto(Combo combo) {
        return isNull(combo)
                ? null
                : ComboDto
                .builder()
                .withItems(ItemMapper.toDto(combo.getItems()))
                .build();
    }
}
