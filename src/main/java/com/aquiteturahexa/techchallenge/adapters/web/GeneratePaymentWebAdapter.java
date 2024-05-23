package com.aquiteturahexa.techchallenge.adapters.web;

import com.aquiteturahexa.techchallenge.core.exceptions.PaymentNotGeneratedException;
import com.aquiteturahexa.techchallenge.core.model.Payment;
import com.aquiteturahexa.techchallenge.core.ports.out.GeneratePaymentPortOut;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class GeneratePaymentWebAdapter implements GeneratePaymentPortOut {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.systemDefault());

    @Value("${mercadopago.token}")
    private String accessToken;


    @Override
    public Payment generate(Payment payment) throws PaymentNotGeneratedException {

        var order = payment.getOrder();
        try {
            MercadoPagoConfig.setAccessToken(accessToken);

            PaymentClient paymentClient = new PaymentClient();

            PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
                    .transactionAmount(order.getAmount())
                    .description("Pedido " + order.getId())
                    .paymentMethodId("pix")
                    .payer(
                            PaymentPayerRequest.builder()
                                    .email(order.getRequester().getEmail().getEmail())
                                    .firstName(order.getRequester().getName().split(" ")[0])
                                    .lastName(order.getRequester().getName().split(" ")[order.getRequester().getName().split(" ").length - 1])
                                    .build())
                    .build();

            com.mercadopago.resources.payment.Payment createPayment = paymentClient.create(paymentCreateRequest);

            payment.addPaymentDetails("QR_CODE", createPayment.getPointOfInteraction().getTransactionData().getQrCode());

        } catch (Exception e) {
            throw new PaymentNotGeneratedException(e, "Error generating payment");
        }

        return payment;
    }
}
