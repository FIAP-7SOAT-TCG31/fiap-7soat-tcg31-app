package com.cleanarchitecture.techchallenge.persistence.repositories;

import com.cleanarchitecture.techchallenge.persistence.entities.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, String> {
}

