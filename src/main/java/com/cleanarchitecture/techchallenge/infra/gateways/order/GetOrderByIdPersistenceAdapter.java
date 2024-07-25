package com.cleanarchitecture.techchallenge.infra.gateways.order;

import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.persistence.entities.OrderEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetOrderByIdPersistenceAdapter implements GetOrderByIdGateway {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Optional<Order> get(String orderId) {
        final var entity = orderJpaRepository.findById(Long.valueOf(orderId));

        return entity.map(OrderEntity::toDomain);
    }
}
