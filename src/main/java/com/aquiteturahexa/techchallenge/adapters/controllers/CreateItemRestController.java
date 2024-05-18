package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateItemDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ItemMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateItemPortIn;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateItemRestController {

        private final CreateItemPortIn createItemPortIn;

        @PostMapping(path = "/api/v1/items")
        public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                        @RequestBody RequestCreateItemDto body) {

                var itemToCreate = ItemMapper.toDomain(body.getItem());
                var item = createItemPortIn.create(itemToCreate);

                final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(item.getId())
                                .toUri();

                return ResponseEntity
                                .created(location)
                                .body(item);
        }

}
