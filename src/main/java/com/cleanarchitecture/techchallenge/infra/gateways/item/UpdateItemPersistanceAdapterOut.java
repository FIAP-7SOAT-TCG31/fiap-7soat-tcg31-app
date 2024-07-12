package com.cleanarchitecture.techchallenge.infra.gateways.item;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdateItemPersistanceAdapterOut implements UpdateItemGateway {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Item update(Item item) {
        var savedItem = itemJpaRepository.save(ItemEntity.toEntity(item));
        return ItemEntity.toDomain(savedItem, null);
    }

}
