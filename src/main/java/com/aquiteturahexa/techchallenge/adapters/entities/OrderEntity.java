package com.aquiteturahexa.techchallenge.adapters.entities;

import java.util.List;

import com.aquiteturahexa.techchallenge.core.model.Combo;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private User reqUser;
    // private List<Combo> combos;
    private Float totalPrice;
    // private Status status;
}
