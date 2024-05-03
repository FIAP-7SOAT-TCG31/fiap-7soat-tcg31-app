package com.aquiteturahexa.techchallenge.adapters.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.core.ports.OrderServicePort;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderServicePort orderServicePort;

    @GetMapping
    public String testeTeste() {

        return "Olá imbecil";
    }
}
