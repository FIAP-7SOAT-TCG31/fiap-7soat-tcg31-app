package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.core.model.Order;
import com.aquiteturahexa.techchallenge.core.model.Status;
import com.aquiteturahexa.techchallenge.core.ports.in.OrderServicePort;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderServicePort orderServicePort;

    /*
     * @GetMapping
     * public String testeTeste() {
     * 
     * return "Olá imbecil";
     * }
     */

    @PostMapping()
    public Order createOrder(@RequestBody Order order) {
        return orderServicePort.saveOrder(order);
    }

    @GetMapping
    public List<Order> findAll() {

        return orderServicePort.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(Long id) {
        return orderServicePort.findById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(Long id, Order order) {
        return orderServicePort.updateOrder(id, order);
    }

    @PutMapping("/status/{id}")
    public Order updateStatus(Long id, Order order, Status status) {
        return orderServicePort.updateStatus(id, order, status);
    }

}
