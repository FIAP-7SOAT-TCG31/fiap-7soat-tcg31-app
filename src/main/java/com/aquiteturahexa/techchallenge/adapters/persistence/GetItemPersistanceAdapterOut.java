package com.aquiteturahexa.techchallenge.adapters.persistence;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ItemMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ItemRepository;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.out.GetItemPortOut;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetItemPersistanceAdapterOut implements GetItemPortOut {

        private final ItemRepository itemRepository;

        @Override
        public Optional<Item> get(Long id) {
                var entity = itemRepository.findById(id);
                return entity.map(ItemMapper::toDomain);

        }
}
