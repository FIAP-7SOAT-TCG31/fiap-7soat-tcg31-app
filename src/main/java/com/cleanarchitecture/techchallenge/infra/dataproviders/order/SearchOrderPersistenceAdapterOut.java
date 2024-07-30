package com.cleanarchitecture.techchallenge.infra.dataproviders.order;

import com.cleanarchitecture.techchallenge.application.gateways.SearchOrderGateway;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import com.cleanarchitecture.techchallenge.persistence.entities.ClientEntity;
import com.cleanarchitecture.techchallenge.persistence.entities.OrderEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.OrderJpaRepository;
import com.cleanarchitecture.techchallenge.persistence.specifications.OrderSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SearchOrderPersistenceAdapterOut implements SearchOrderGateway {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public List<Order> search(ZonedDateTime start,
                              ZonedDateTime end,
                              List<Status> statusList,
                              Client requester) {

        var orders = orderJpaRepository.findAll(Specification
                .where(OrderSpecification.hasRequestedAtBetween(start, end))
                .and(OrderSpecification.hasStatus(CollectionUtils.isEmpty(statusList) ? List.of()
                        : statusList.stream().map(Enum::name).toList()))
                .and(OrderSpecification.hasRequester(ClientEntity.toEntity(requester))));

        return orders
                .stream()
                .map(OrderEntity::toDomain)
                .toList();
    }
}
