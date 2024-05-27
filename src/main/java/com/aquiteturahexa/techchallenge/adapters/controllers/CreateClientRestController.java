package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.Map;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.PaymentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Create Client Controller", description = "Controller for receiving client data and save it in the database")
public class CreateClientRestController {

        private final CreateClientPortIn createClientPortIn;

    @PostMapping(path = "/api/v1/clients")
    @Operation(summary = "Create client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Receive client data and save it in the database",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDto.class)))
    })
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
