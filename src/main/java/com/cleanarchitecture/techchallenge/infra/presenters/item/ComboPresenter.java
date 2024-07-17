package com.cleanarchitecture.techchallenge.infra.presenters.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ComboDto;
import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;

public class ComboPresenter {

    private static ComboPresenter comboPresenter;

    private ComboPresenter() {
    }

    public static ComboPresenter getInstance() {
        if (comboPresenter == null) {
            comboPresenter = new ComboPresenter();
        }

        return comboPresenter;
    }

    public Combo toDomain(ComboDto combo) {
        return combo == null
                ? null
                : new Combo(ItemPresenter.getInstance().toDomain(combo.getItems()));
    }

    public ComboDto toDto(Combo combo) {
        return combo == null
                ? null
                : ComboDto
                .builder()
                .withItems(ItemPresenter.getInstance().toDto(combo.getItems()))
                .build();
    }
}
