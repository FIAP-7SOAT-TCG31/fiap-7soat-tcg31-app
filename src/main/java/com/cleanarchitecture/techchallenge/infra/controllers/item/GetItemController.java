package com.cleanarchitecture.techchallenge.infra.controllers.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetItemUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ItemPresenter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetItemController {

    private final GetItemUseCase getItemUseCase;
    private final ItemPresenter itemPresenter;

    public GetItemController(GetItemUseCase getItemUseCase) {
        this.getItemUseCase = getItemUseCase;
        this.itemPresenter = ItemPresenter.getInstance();
    }

    public Optional<ItemDto> getById(Long id) {
        var item = getItemUseCase.get(id);
        return item.map(itemPresenter::toDto);
    }

}
