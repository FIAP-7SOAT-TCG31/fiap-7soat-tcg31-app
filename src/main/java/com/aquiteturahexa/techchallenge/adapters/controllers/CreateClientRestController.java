package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ClientDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ClientMapper;
import com.aquiteturahexa.techchallenge.core.ports.in.CreateClientPortIn;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CreateClientRestController {

        private final CreateClientPortIn createClientPortIn;

        @PostMapping(path = "/api/v1/clients")
        public ResponseEntity<?> create(@RequestHeader Map<String, String> headers,
                        @RequestBody ClientDto body) {

                var client = createClientPortIn.create(ClientMapper.toDomain(body));
                final var location = ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(client.getId())
                                .toUri();

                return ResponseEntity
                                .created(location)
                                .body(ClientMapper.toDto(client));
        }

}
