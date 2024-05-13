package com.aquiteturahexa.techchallenge.adapters.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_users")
@Builder(setterPrefix = "with")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cpf;

    private String name;
    private String email;
}
