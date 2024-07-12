package com.cleanarchitecture.techchallenge.persistence.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.cleanarchitecture.techchallenge.persistence.entities.ItemEntity;

public class ItemSpecification {

  public static Specification<ItemEntity> hasItemType(String type) {
    return (root, query, criteriaBuilder) -> {
      if (type == null) {
        return criteriaBuilder.conjunction();
      }
      return criteriaBuilder.equal(root.get("type"), type);
    };
  }
}