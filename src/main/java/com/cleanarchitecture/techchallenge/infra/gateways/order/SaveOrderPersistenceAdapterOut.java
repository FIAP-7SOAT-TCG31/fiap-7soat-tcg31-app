package com.cleanarchitecture.techchallenge.infra.gateways.order;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;
import com.cleanarchitecture.techchallenge.persistence.entities.OrderEntity;
import com.cleanarchitecture.techchallenge.persistence.entities.OrderItemEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveOrderPersistenceAdapterOut implements SaveOrderGateway {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order create(Order createdOrder) {

        var order = orderJpaRepository.save(OrderEntity.toEntity(createdOrder));
        order.getItens().clear();
        order.getItens().addAll(
                createdOrder
                        .getCombo()
                        .getItems()
                        .stream()
                        .map(item ->
                                OrderItemEntity
                                        .builder()
                                        .withOrder(order)
                                        .withItem(ItemEntity
                                                .builder()
                                                .withId(item.getId())
                                                .withName(item.getName())
                                                .withPrice(item.getPrice())
                                                .withType(item.getType().name())
                                                .build())
                                        .withQuantity(item.getQuantity())
                                        .withNote(item.getNote())
                                        .build())
                        .toList()
        );
        return OrderEntity.toDomain(orderJpaRepository.save(order));
    }
}
