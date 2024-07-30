package com.cleanarchitecture.techchallenge.persistence.entities;


import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.order.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_orders")
@Builder(setterPrefix = "with", toBuilder = true)
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private ClientEntity requester;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> itens;

    private ZonedDateTime requestedAt;
    private ZonedDateTime updatedAt;
    private BigDecimal amount;
    private String status;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    public static OrderEntity toEntity(Order order) {
        return OrderEntity
                .builder()
                .withId(order.getId())
                .withRequestedAt(order.getRequestedAt().atZone(ZoneId.systemDefault()))
                .withStatus(order.getStatus().name())
                .withAmount(order.getAmount())
                .withRequester(ClientEntity.toEntity(order.getRequester()))
                .withUpdatedAt(order.getUpdatedAt() == null ? null : order.getUpdatedAt().atZone(ZoneId.systemDefault()))
                .withItens(OrderItemEntity.toEntity(order.getCombo()))
                .withPayment(PaymentEntity.toEntity(order.getPayment()))
                .build();
    }

    public static Order toDomain(OrderEntity order) {
        return new Order(order.getId(),
                ClientEntity.toDomain(order.getRequester()),
                OrderItemEntity.toDomain(order.getItens()),
                order.getRequestedAt().toInstant(),
                order.getUpdatedAt() == null ? null : order.getUpdatedAt().toInstant(),
                order.getAmount(),
                Status.valueOf(order.getStatus()),
                PaymentEntity.toDomain(order.getPayment()));
    }
}
