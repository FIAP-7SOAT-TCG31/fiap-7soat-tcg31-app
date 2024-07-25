package com.cleanarchitecture.techchallenge.persistence.entities;

import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_payments")
@Builder(setterPrefix = "with", toBuilder = true)
public class PaymentEntity {

    @Id
    private String id;

    private String method;

    private boolean wasPaid;

    private ZonedDateTime paidAt;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentDetailsEntity> paymentDetails;

    public static Payment toDomain(PaymentEntity payment) {
        return payment == null
                ? null
                : new Payment(
                payment.getId(),
                payment.getMethod(),
                PaymentDetailsEntity.toDomain(payment.getPaymentDetails()),
                payment.isWasPaid(),
                payment.getPaidAt() == null ? null : payment.getPaidAt().toInstant()
        );
    }

    public static PaymentEntity toEntity(Payment payment) {
        return payment == null
                ? null
                : PaymentEntity
                .builder()
                .withId(payment.getId())
                .withMethod(payment.getType())
                .withPaymentDetails(PaymentDetailsEntity.toEntity(payment.getPaymentDetails(), payment))
                .withWasPaid(payment.getPaid())
                .withPaidAt(payment.getPaidAt() == null ? null : payment.getPaidAt().atZone(ZoneId.systemDefault()))
                .build();
    }
}
