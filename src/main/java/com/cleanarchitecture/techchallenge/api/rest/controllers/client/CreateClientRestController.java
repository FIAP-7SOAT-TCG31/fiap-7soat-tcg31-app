package com.cleanarchitecture.techchallenge.api.rest.controllers.client;

import com.cleanarchitecture.techchallenge.infra.controllers.client.CreateClientController;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateClientUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "Create Client Controller", description = "Controller for receiving client data and save it in the database")
public class CreateClientRestController {

    private final CreateClientController createClientController;

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

        var client = createClientController.create(body);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(client.getId())
                        .toUri())
                .body(client);
    }

}
