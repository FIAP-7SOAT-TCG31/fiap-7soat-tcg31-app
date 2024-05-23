package com.aquiteturahexa.techchallenge.adapters.controllers;

import com.aquiteturahexa.techchallenge.adapters.controllers.dto.ClientDto;
import com.aquiteturahexa.techchallenge.adapters.controllers.mappers.ClientMapper;
import com.aquiteturahexa.techchallenge.core.model.Client;
import com.aquiteturahexa.techchallenge.core.ports.in.ClientServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class ClientController {

    private final ClientServicePort clientServicePort;

    @PostMapping()
    public Client create(@RequestBody ClientDto client) {

        return clientServicePort.saveClient(ClientMapper.toDomain(client));
    }

    @GetMapping()
    public List<Client> findAll() {

        return clientServicePort.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {

        return clientServicePort.findById(id);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody ClientDto client) {
        return clientServicePort.updateClient(id, ClientMapper.toDomain(client));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {

        clientServicePort.deleteById(id);
    }

}
