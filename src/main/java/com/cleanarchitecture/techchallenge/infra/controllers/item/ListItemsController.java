package com.cleanarchitecture.techchallenge.infra.controllers.item;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ItemDto;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;
import com.cleanarchitecture.techchallenge.domain.usecases.ListItemsUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.item.ItemPresenter;
import io.micrometer.common.util.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
public class ListItemsController {

    private final ListItemsUseCase listItemsUseCase;
    private final ItemPresenter itemPresenter;

    public ListItemsController(ListItemsUseCase listItemsUseCase) {
        this.listItemsUseCase = listItemsUseCase;
        this.itemPresenter = ItemPresenter.getInstance();
    }

    public List<ItemDto> search(String itemType) {

        var filterByType = StringUtils.isNotEmpty(itemType);
        var itemTypeEnum = filterByType ? ItemType.valueOf(itemType) : null;

        var items = filterByType
                ? listItemsUseCase.getAllByType(itemTypeEnum)
                : listItemsUseCase.getAll();

        return itemPresenter.toDto(items);

    }

}
