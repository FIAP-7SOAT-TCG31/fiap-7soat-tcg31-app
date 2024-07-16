package com.cleanarchitecture.techchallenge.api.rest.dtos.item;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true, setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ItemDto {

    private Long id;
    private String name;
    private String type;
    private BigDecimal price;
    private Float quantity;
    private String description;
    private List<String> images;
    private String note;

}
