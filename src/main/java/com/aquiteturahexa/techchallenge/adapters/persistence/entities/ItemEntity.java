package com.aquiteturahexa.techchallenge.adapters.persistence.entities;

import java.math.BigDecimal;
import java.util.List;

import com.aquiteturahexa.techchallenge.adapters.persistence.utils.StringListConverter;

import jakarta.persistence.Convert;
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
@Table(name = "tb_items")
@Builder(setterPrefix = "with")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private BigDecimal price;
    private Float quantity;
    private String description;

    @Convert(converter = StringListConverter.class)
    private List<String> images;
}
