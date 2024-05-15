package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.core.ports.in.ListItemsPortIn;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ListItemsRestController {

        private final ListItemsPortIn listItemsPortIn;

        @GetMapping(path = "/api/v1/items")
        public ResponseEntity<?> getById(@RequestHeader Map<String, String> headers) {

                var item = listItemsPortIn.getAll();

                return item.isEmpty()
                                ? ResponseEntity.notFound().build()
                                : ResponseEntity.ok(item);

        }

}
