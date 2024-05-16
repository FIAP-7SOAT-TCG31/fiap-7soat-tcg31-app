package com.aquiteturahexa.techchallenge.adapters.controllers;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquiteturahexa.techchallenge.adapters.persistence.PaymentAdapter;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class PaymentController {

    private PaymentAdapter paymentAdapter = new PaymentAdapter();

    @GetMapping("payment")
    public void paymentChekout(HttpServletResponse response) throws IOException {
        paymentAdapter.paymentChekout(response);
    }

}
