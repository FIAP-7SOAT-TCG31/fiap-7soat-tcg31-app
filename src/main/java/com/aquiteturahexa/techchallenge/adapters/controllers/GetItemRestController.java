package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.core.ports.in.GetItemPortIn;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GetItemRestController {

        private final GetItemPortIn getItemPortIn;

        @GetMapping(path = "/api/v1/items/{id}")
        public ResponseEntity<?> getById(@RequestHeader Map<String, String> headers, @PathVariable("id") String id) {

                var item = getItemPortIn.get(Long.parseLong(id));

                return item.isEmpty()
                                ? ResponseEntity.notFound().build()
                                : ResponseEntity.ok(item);

        }

}
