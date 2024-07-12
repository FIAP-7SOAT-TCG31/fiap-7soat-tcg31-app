package com.cleanarchitecture.techchallenge.persistence.entities;

import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;
import com.cleanarchitecture.techchallenge.domain.entities.payment.PaymentDetails;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_payment_details")
@Builder(setterPrefix = "with", toBuilder = true)
public class PaymentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String value;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    public static PaymentDetails toDomain(PaymentDetailsEntity paymentDetails) {
        return new PaymentDetails(paymentDetails.getKey(), paymentDetails.getValue());
    }

    public static List<PaymentDetails> toDomain(List<PaymentDetailsEntity> paymentDetails) {
        return paymentDetails == null || paymentDetails.isEmpty()
                ? List.of()
                : paymentDetails
                .stream()
                .map(PaymentDetailsEntity::toDomain)
                .toList();
    }

    public static List<PaymentDetailsEntity> toEntity(List<PaymentDetails> paymentDetails, Payment payment) {
        return paymentDetails == null || paymentDetails.isEmpty()
                ? List.of()
                : paymentDetails
                .stream()
                .map(paymentDetail -> PaymentDetailsEntity.toEntity(paymentDetail, null))
                .toList();
    }

    public static PaymentDetailsEntity toEntity(PaymentDetails paymentDetails, Payment payment) {
        return PaymentDetailsEntity
                .builder()
                .withKey(paymentDetails.getKey())
                .withValue(paymentDetails.getValue())
                .withPayment(PaymentEntity.toEntity(payment))
                .build();
    }
}
