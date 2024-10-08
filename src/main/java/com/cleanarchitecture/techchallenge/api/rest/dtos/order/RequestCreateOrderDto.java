package com.cleanarchitecture.techchallenge.api.rest.dtos.order;

import com.cleanarchitecture.techchallenge.api.rest.dtos.item.ComboDto;
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
public class RequestCreateOrderDto {

    private ComboDto combo;
}
