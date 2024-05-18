package com.aquiteturahexa.techchallenge.adapters.controllers;

import static java.util.Objects.isNull;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.RequestCreateItemDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ItemMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.UpdateItemPortIn;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UpdateItemRestController {

        private final UpdateItemPortIn updateItemPortIn;

        @PutMapping(path = "/api/v1/items/{id}")
        public ResponseEntity<?> updateItem(
                        @RequestHeader Map<String, String> headers,
                        @PathVariable("id") String id,
                        @RequestBody RequestCreateItemDto body) {

                var updatedItem = updateItemPortIn.update(
                                Long.parseLong(id),
                                ItemMapper.toDomain(body.getItem()));

                if (isNull(updatedItem)) {
                        return ResponseEntity.notFound().build();
                }

                return ResponseEntity.ok(updatedItem);
        }

}
