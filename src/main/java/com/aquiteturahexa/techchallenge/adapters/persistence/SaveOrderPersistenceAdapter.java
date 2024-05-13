package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ItemEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderItemEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.OrderMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.OrderRepository;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.ports.out.SaveOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveOrderPersistenceAdapter implements SaveOrderPort {

    private final OrderRepository orderRepository;

    @Override
    public Order create(Order createdOrder) {

        var order = orderRepository.save(OrderMapper.toEntity(createdOrder));
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
                                        .build())
                        .toList()
        );
        return OrderMapper.toDomain(orderRepository.save(order));
    }
}
