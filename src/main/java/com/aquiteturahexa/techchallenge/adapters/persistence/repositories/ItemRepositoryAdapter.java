package com.aquiteturahexa.techchallenge.adapters.persistence.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ItemEntity;
import com.aquiteturahexa.techchallenge.core.model.Item;
import com.aquiteturahexa.techchallenge.core.ports.out.ItemRepositoryPort;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ItemRepositoryAdapter implements ItemRepositoryPort {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public Item save(Item item) {
        ItemEntity entity = modelMapper.map(item, ItemEntity.class);
        ItemEntity storedEntity = itemRepository.save(entity);
        return modelMapper.map(storedEntity, Item.class);
    }

    @Override
    public List<Item> findAll() {
        List<ItemEntity> list = itemRepository.findAll();
        return list.stream()
                .map(itemEntity -> modelMapper.map(itemEntity, Item.class))
                .collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id) {
        Optional<ItemEntity> obj = itemRepository.findById(id);

        return obj.map(itemEntity -> modelMapper.map(itemEntity, Item.class))
                .orElse(null);
    }

    @Override
    public Item update(Long id, Item item) {
        Item existingItem = findById(id);
        return save(existingItem);
    }

}
