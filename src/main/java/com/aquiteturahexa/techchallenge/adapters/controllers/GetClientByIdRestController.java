package com.aquiteturahexa.techchallenge.adapters.controllers;


import com.aquiteturahexa.techchallenge.core.ports.in.GetClientByIdPortIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Get Client By Id Controller", description = "Controller for return client data by his id")
public class GetClientByIdRestController {

    private final GetClientByIdPortIn getClientByIdPortIn;

    @GetMapping(path = "/api/v1/clients/{id}")
    @Operation(summary = "Return client data by his id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully returned client data"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @PathVariable("id") Long id) {

        var client = getClientByIdPortIn.find(id);

        return client.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(client);
    }

}
