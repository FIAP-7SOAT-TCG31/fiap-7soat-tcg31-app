package com.aquiteturahexa.techchallenge.adapters.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aquiteturahexa.techchallenge.core.exceptions.PaymentNotGeneratedException;
import com.aquiteturahexa.techchallenge.core.model.Payment;
import com.aquiteturahexa.techchallenge.core.ports.out.GeneratePaymentPortOut;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GeneratePaymentWebAdapter implements GeneratePaymentPortOut {

    private static final String QR_CODE = "QR_CODE";

    @Value("${mercadopago.token}")
    private String accessToken;

    @Value("${mercadopago.enabled}")
    private Boolean isIntegrationEnabled;

    @Override
    public Payment generate(Payment payment) throws PaymentNotGeneratedException {

        var order = payment.getOrder();
        try {
            MercadoPagoConfig.setAccessToken(accessToken);

            if (!this.isIntegrationEnabled) {
                payment.addPaymentDetails(QR_CODE,
                        "00020126360014BR.GOV.BCB.PIX0114999999999999995204000053039865406123.995802BR5910FiapBurger6009Sao Paulo62160512Pagamento1236304F909");
                return payment;

            }

            PaymentClient paymentClient = new PaymentClient();

            PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
                    .transactionAmount(order.getAmount())
                    .description("Pedido " + order.getId())
                    .paymentMethodId("pix")
                    .payer(
                            PaymentPayerRequest.builder()
                                    .email(order.getRequester().getEmail().getEmail())
                                    .firstName(order.getRequester().getName().split(" ")[0])
                                    .lastName(order.getRequester().getName()
                                            .split(" ")[order.getRequester().getName().split(" ").length - 1])
                                    .build())
                    .build();

            com.mercadopago.resources.payment.Payment createPayment = paymentClient.create(paymentCreateRequest);

            payment.addPaymentDetails(QR_CODE, createPayment.getPointOfInteraction().getTransactionData().getQrCode());

        } catch (Exception e) {
            throw new PaymentNotGeneratedException(e, "Error generating payment");
        }

        return payment;
    }

    @Override
    public boolean isType(Payment payment) {
        return QR_CODE.equalsIgnoreCase(payment.getType());
    }
}
