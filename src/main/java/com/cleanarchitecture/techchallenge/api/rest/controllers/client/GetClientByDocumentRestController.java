package com.cleanarchitecture.techchallenge.api.rest.controllers.client;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.infra.controllers.client.GetClientByDocumentController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Get Client By Document Controller", description = "Controller for return client data by his document number")
public class GetClientByDocumentRestController {

    private final GetClientByDocumentController clientByDocumenController;

    @GetMapping(path = "/api/v1/clients")
    @Operation(summary = "Return client data by his document number")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully returned client data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDto.class))),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @RequestParam("cpf") String cpf) {

        var client = clientByDocumenController.get(cpf);
        return client.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
