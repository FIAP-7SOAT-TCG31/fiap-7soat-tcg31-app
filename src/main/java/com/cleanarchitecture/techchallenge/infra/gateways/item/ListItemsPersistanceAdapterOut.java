package com.cleanarchitecture.techchallenge.infra.gateways.item;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;
import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.ItemJpaRepository;
import com.cleanarchitecture.techchallenge.persistence.specifications.ItemSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListItemsPersistanceAdapterOut implements ListItemsGateway {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public List<Item> getAll() {
        var entities = itemJpaRepository.findAll();
        return entities
                .stream()
                .map(itemEntity -> ItemEntity.toDomain(itemEntity, null))
                .toList();

    }

    @Override
    public List<Item> getAllByType(ItemType itemType) {
        var entities = itemJpaRepository.findAll(Specification.where(ItemSpecification.hasItemType(itemType.toString())));
        return entities
                .stream()
                .map(itemEntity -> ItemEntity.toDomain(itemEntity, null))
                .toList();
    }
}
