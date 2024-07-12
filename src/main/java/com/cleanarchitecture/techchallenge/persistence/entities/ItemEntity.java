package com.cleanarchitecture.techchallenge.persistence.entities;

import java.math.BigDecimal;
import java.util.List;

import com.cleanarchitecture.techchallenge.persistence.utils.StringListConverter;

import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import com.cleanarchitecture.techchallenge.domain.entities.item.ItemType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_items")
@Builder(setterPrefix = "with")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private BigDecimal price;
    private Float quantity;
    private String description;

    @Convert(converter = StringListConverter.class)
    private List<String> images;

    public static Item toDomain(ItemEntity item, Float quantity) {
        return new Item(
                item.getId(),
                item.getName(),
                ItemType.valueOf(item.getType()),
                item.getPrice(),
                quantity,
                item.getDescription(),
                item.getImages());
    }

    public static ItemEntity toEntity(Item item) {
        return ItemEntity
                .builder()
                .withId(item.getId())
                .withName(item.getName())
                .withPrice(item.getPrice())
                .withType(item.getType().name())
                .withQuantity(item.getQuantity())
                .withDescription(item.getDescription())
                .withImages(item.getImages())
                .build();
    }
}
