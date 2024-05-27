package com.aquiteturahexa.techchallenge.adapters.persistence.specifications;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ClientEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderEntity;

public class OrderSpecification {

    public static Specification<OrderEntity> hasRequestedAtBetween(ZonedDateTime start, ZonedDateTime end) {
        return (root, query, criteriaBuilder) -> {
            if (start == null || end == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(root.get("requestedAt"), start, end);
        };
    }

    public static Specification<OrderEntity> hasStatus(List<String> statusList) {
        return (root, query, criteriaBuilder) -> {
            if (statusList == null || statusList.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return root.get("status").in(statusList);
        };
    }

    public static Specification<OrderEntity> hasRequester(ClientEntity requester) {
        return (root, query, criteriaBuilder) -> {
            if (requester == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("requester"), requester);
        };
    }
}