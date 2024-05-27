package com.aquiteturahexa.techchallenge.adapters.persistence;

import com.aquiteturahexa.techchallenge.adapters.persistence.mapper.OrderMapper;
import com.aquiteturahexa.techchallenge.adapters.persistence.repositories.OrderRepository;
import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.ports.out.GetOrderByIdPortOut;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetOrderByIdPersistenceAdapter implements GetOrderByIdPortOut {

    private final OrderRepository orderRepository;

    @Override
    public Optional<Order> get(String orderId) {
        final var entity = orderRepository.findById(Long.valueOf(orderId));

        return entity.map(OrderMapper::toDomain);
    }
}
