package com.cleanarchitecture.techchallenge.infra.controllers.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.item.RequestCreateItemDto;
import com.cleanarchitecture.techchallenge.domain.usecases.UpdateItemUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ItemPresenter;
import org.springframework.stereotype.Component;

@Component
public class UpdateItemController {

    private final UpdateItemUseCase updateItemUseCase;
    private final ItemPresenter itemPresenter;

    public UpdateItemController(UpdateItemUseCase updateItemUseCase) {
        this.updateItemUseCase = updateItemUseCase;
        this.itemPresenter = ItemPresenter.getInstance();
    }

    public ItemDto updateItem(Long id, RequestCreateItemDto body) {

        var updatedItem = updateItemUseCase.update(id, itemPresenter.toDomain(body.getItem()));

        return updatedItem == null
                ? null
                : itemPresenter.toDto(updatedItem);
    }

}
