package com.cleanarchitecture.techchallenge.infra.controllers.client;

import com.cleanarchitecture.techchallenge.api.rest.dtos.client.ClientDto;
import com.cleanarchitecture.techchallenge.domain.usecases.CreateClientUseCase;
import com.cleanarchitecture.techchallenge.infra.presenters.client.ClientPresenter;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class CreateClientController {

    private final CreateClientUseCase createClientUseCase;
    private final ClientPresenter clientPresenter;

    public CreateClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
        this.clientPresenter = ClientPresenter.getInstance();
    }


    public ClientDto create(String token) {
        String[] tokenParts = token.split("\\.");
        String payload = new String(Base64.getUrlDecoder().decode(tokenParts[1]));
        JSONObject jsonObject = new JSONObject(payload);

        try {
            if (StringUtils.isBlank(jsonObject.getString("custom:cpf"))) {
                throw new BadCredentialsException("Token not valid");
            }

            return create(ClientDto
                    .builder()
                    .withCpf(jsonObject.getString("custom:cpf"))
                    .withEmail(jsonObject.getString("email"))
                    .withName(jsonObject.getString("name"))
                    .build());
        } catch (Exception e) {
            return null;
        }

    }


    public ClientDto create(ClientDto body) {
        var client = createClientUseCase.create(clientPresenter.toDomain(body));
        return clientPresenter.toDto(client);
    }

}
