package com.cleanarchitecture.techchallenge.api.rest.controllers.client;

import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientMapper;
import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.usecases.GetClientByIdUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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

    private final GetClientByIdUseCase getClientByIdUseCase;

    @GetMapping(path = "/api/v1/clients/{id}")
    @Operation(summary = "Return client data by his id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully returned client data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientDto.class))
            ),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<?> get(@RequestHeader Map<String, String> headers,
                                 @PathVariable("id") Long id) {

        var client = getClientByIdUseCase.find(id);

        return client.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(ClientMapper.toDto(client.get()));
    }

}
