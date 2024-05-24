package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ClientMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByIdPortIn;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GetClientByIdRestController {

    private final GetClientByIdPortIn getClientByIdPortIn;

    @GetMapping(path = "/api/v1/clients/{id}")
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
            @PathVariable("id") Long id) {

        var client = getClientByIdPortIn.find(id);

        return client.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(ClientMapper.toDto(client.get()));
    }

}
