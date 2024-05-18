package com.aquiteturahexa.techchallenge.adapters.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ItemMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ItemRepository;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.out.UpdateItemPortOut;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdateItemPersistanceAdapterOut implements UpdateItemPortOut {

        private final ItemRepository itemRepository;

        @Override
        public Item update(Item item) {
                var savedItem = itemRepository.save(ItemMapper.toEntity(item));
                return ItemMapper.toDomain(savedItem);
        }

        @Override
        public Optional<Item> findById(Long id) {
                var entity = itemRepository.findById(id);
                return entity.map(ItemMapper::toDomain);
        }
}
