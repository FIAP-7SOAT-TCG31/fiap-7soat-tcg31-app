package com.aquiteturahexa.techchallenge.adapters.persistence.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.aquiteturahexa.techchallenge.adapters.persistence.entities.ItemEntity;

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