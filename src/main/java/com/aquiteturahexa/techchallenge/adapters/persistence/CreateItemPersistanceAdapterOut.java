package com.aquiteturahexa.techchallenge.adapters.persistence;

import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ItemMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ItemRepository;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.out.CreateItemPortOut;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreateItemPersistanceAdapterOut implements CreateItemPortOut {

        private final ItemRepository itemRepository;

        @Override
        public Item create(Item itemToCreate) {
                var createdItem = itemRepository.save(ItemMapper.toEntity(itemToCreate));
                return ItemMapper.toDomain(createdItem);
        }
}
