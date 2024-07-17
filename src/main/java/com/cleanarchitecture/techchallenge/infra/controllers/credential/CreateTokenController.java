package com.cleanarchitecture.techchallenge.infra.controllers.credential;

import com.cleanarchitecture.techchallenge.api.rest.dtos.credential.AccessTokenDto;
import com.cleanarchitecture.techchallenge.api.rest.dtos.credential.RequestTokenDto;
import com.cleanarchitecture.techchallenge.api.rest.provider.JwtService;
import com.cleanarchitecture.techchallenge.domain.usecases.GetUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Component
public class CreateTokenController {

    private final GetUserUseCase getUserUseCase;
    private final JwtService jwtService;

    public CreateTokenController(GetUserUseCase getUserUseCase, JwtService jwtService) {
        this.getUserUseCase = getUserUseCase;
        this.jwtService = jwtService;
    }


    public AccessTokenDto create(RequestTokenDto body) {

        var user = getUserUseCase.getUser(body.getUsername(), body.getPassword());

        return user.map(value -> AccessTokenDto
                .builder()
                .withToken(jwtService.generateToken(value.getUsername()))
                .build()).orElse(null);
    }

}
