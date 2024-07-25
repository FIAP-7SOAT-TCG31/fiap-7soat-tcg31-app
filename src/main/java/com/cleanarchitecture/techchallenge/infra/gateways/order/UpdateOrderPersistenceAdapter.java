package com.cleanarchitecture.techchallenge.infra.gateways.order;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;
import com.cleanarchitecture.techchallenge.persistence.entities.OrderEntity;
import com.cleanarchitecture.techchallenge.persistence.entities.OrderItemEntity;
import com.cleanarchitecture.techchallenge.persistence.entities.PaymentEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.OrderJpaRepository;
import com.cleanarchitecture.techchallenge.persistence.repositories.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateOrderPersistenceAdapter implements UpdateOrderGateway {

    private final OrderJpaRepository orderJpaRepository;
    private final PaymentJpaRepository paymentJpaRepository;

    @Override
    public Order update(Order updatedOrder) {

        if (updatedOrder.getPayment() != null) {
            var payment = PaymentEntity.toEntity(updatedOrder.getPayment());
            payment = paymentJpaRepository.save(payment);
            updatedOrder.setPayment(PaymentEntity.toDomain(payment));
        }
        var order = orderJpaRepository.save(OrderEntity.toEntity(updatedOrder));

        order.getItens().clear();
        order.getItens().addAll(
                updatedOrder
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

        var entity = orderJpaRepository.save(order);
        return OrderEntity.toDomain(entity);
    }
}
