package com.cleanarchitecture.techchallenge.infra.gateways.item;

import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;
import org.springframework.stereotype.Component;

import com.cleanarchitecture.techchallenge.persistence.repositories.ItemJpaRepository;
import com.cleanarchitecture.techchallenge.domain.entities.item.Item;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateItemPersistanceAdapterOut implements CreateItemGateway {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Item create(Item itemToCreate) {
        var createdItem = itemJpaRepository.save(ItemEntity.toEntity(itemToCreate));
        return ItemEntity.toDomain(createdItem, null);
    }
}
