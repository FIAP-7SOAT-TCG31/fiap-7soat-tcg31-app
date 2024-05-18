package com.aquiteturahexa.techchallenge.adapters.persistence.specifications;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.OrderEntity;
import com.aquiteturahexa.techchallenge.adapters.persistence.entities.UserEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.ZonedDateTime;

public class OrderSpecification {

    public static Specification<OrderEntity> hasRequestedAtBetween(ZonedDateTime start, ZonedDateTime end) {
        return (root, query, criteriaBuilder) -> {
            if (start == null || end == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.between(root.get("requestedAt"), start, end);
        };
    }

    public static Specification<OrderEntity> hasStatus(String status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<OrderEntity> hasRequester(UserEntity requester) {
        return (root, query, criteriaBuilder) -> {
            if (requester == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("requester"), requester);
        };
    }
}