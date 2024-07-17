package com.cleanarchitecture.techchallenge.infra.controllers.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.item.RequestCreateItemDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateItemUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ItemPresenter;
import org.springframework.stereotype.Component;

@Component
public class CreateItemController {

    private final CreateItemUseCase createItemUseCase;
    private final ItemPresenter itemPresenter;

    public CreateItemController(CreateItemUseCase createItemUseCase) {
        this.createItemUseCase = createItemUseCase;
        this.itemPresenter = ItemPresenter.getInstance();
    }

    public ItemDto create(RequestCreateItemDto body) {

        var itemToCreate = itemPresenter.toDomain(body.getItem());
        var item = createItemUseCase.create(itemToCreate);
        return itemPresenter.toDto(item);
    }

}
