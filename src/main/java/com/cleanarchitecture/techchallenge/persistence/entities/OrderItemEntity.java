package com.cleanarchitecture.techchallenge.persistence.entities;

import com.cleanarchitecture.techchallenge.domain.entities.item.Combo;
import com.cleanarchitecture.techchallenge.domain.entities.item.Item;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_order_items")
@Builder(setterPrefix = "with", toBuilder = true)
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    private Float quantity;
    private String note;
    private boolean done;

    public static Combo toDomain(List<OrderItemEntity> itens) {
        var itemList = itens == null || itens.isEmpty()
                ? new ArrayList<Item>()
                : itens
                .stream()
                .map(item -> ItemEntity.toDomain(item.getItem(), item.getQuantity(), item.getNote()))
                .collect(Collectors.toCollection(ArrayList::new));

        return new Combo(itemList);
    }

    public static List<OrderItemEntity> toEntity(Combo combo) {
        return combo.getItems() == null || combo.getItems().isEmpty()
                ? List.of()
                : combo.getItems()
                .stream()
                .map(item -> OrderItemEntity
                        .builder()
                        .withItem(ItemEntity.toEntity(item))
                        .withQuantity(item.getQuantity())
                        .withNote(item.getNote())
                        .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
