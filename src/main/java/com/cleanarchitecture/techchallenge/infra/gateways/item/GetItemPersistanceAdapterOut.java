package com.cleanarchitecture.techchallenge.infra.gateways.item;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.ItemJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetItemPersistanceAdapterOut implements GetItemGateway {

    private final ItemJpaRepository itemJpaRepository;

    @Override
    public Optional<Item> get(Long id) {
        var entity = itemJpaRepository.findById(id);
        return entity.map(ItemEntity::toDomain);
    }
}
