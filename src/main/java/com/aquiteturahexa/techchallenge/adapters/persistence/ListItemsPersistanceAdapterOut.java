package com.aquiteturahexa.techchallenge.adapters.persistence;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.ItemMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.ItemRepository;
import com.aquiteturahexa.techchallenge.adapters.persistence.specifications.ItemSpecification;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.model.ItemType;
import com.aquiteturahexa.techchallenge.core.ports.out.ListItemsPortOut;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ListItemsPersistanceAdapterOut implements ListItemsPortOut {

        private final ItemRepository itemRepository;

        @Override
        public List<Item> getAll() {
                var entities = itemRepository.findAll();
                return entities.stream().map(ItemMapper::toDomain).toList();

        }

        @Override
        public List<Item> getAllByType(ItemType itemType) {
                var entities = itemRepository.findAll(Specification.where(
                                ItemSpecification.hasItemType(itemType.toString())));
                return entities.stream().map(ItemMapper::toDomain).toList();
        }
}
