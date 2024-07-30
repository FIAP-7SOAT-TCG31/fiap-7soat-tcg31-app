package com.cleanarchitecture.techchallenge.infra.dataproviders.payment;

import com.cleanarchitecture.techchallenge.application.exceptions.PaymentNotGeneratedException;
import com.cleanarchitecture.techchallenge.application.gateways.GeneratePaymentGateway;
import com.cleanarchitecture.techchallenge.domain.entities.order.Order;
import com.cleanarchitecture.techchallenge.domain.entities.payment.Payment;
import com.cleanarchitecture.techchallenge.persistence.entities.PaymentEntity;
import com.cleanarchitecture.techchallenge.persistence.repositories.PaymentJpaRepository;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableConfigurationProperties(MercadoPagoProperties.class)
public class GeneratePaymentWebAdapter implements GeneratePaymentGateway {

    private static final String QR_CODE = "QR_CODE";
    private static final String PIX = "pix";
    private final PaymentJpaRepository paymentJpaRepository;
    private final MercadoPagoProperties properties;

    @Override
    public Payment generate(Payment payment, Order order) throws PaymentNotGeneratedException {

        try {
            MercadoPagoConfig.setAccessToken(properties.getToken());

            if (!this.properties.getEnabled()) {
                payment.addPaymentDetails(QR_CODE,
                        "00020126360014BR.GOV.BCB.PIX0114999999999999995204000053039865406123.995802BR5910FiapBurger6009Sao Paulo62160512Pagamento1236304F909");
                return payment;

            }

            PaymentClient paymentClient = new PaymentClient();

            PaymentCreateRequest paymentCreateRequest = PaymentCreateRequest.builder()
                    .callbackUrl(properties.getCallbackUrl().replaceAll("orderId", String.valueOf(order.getId())))
                    .transactionAmount(order.getAmount())
                    .description("Pedido " + order.getId())
                    .paymentMethodId(payment.getType())
                    .payer(
                            PaymentPayerRequest.builder()
                                    .email(order.getRequester().getEmail().email())
                                    .firstName(order.getRequester().getName().split(" ")[0])
                                    .lastName(order.getRequester().getName()
                                            .split(" ")[order.getRequester().getName().split(" ").length - 1])
                                    .build())
                    .build();

            com.mercadopago.resources.payment.Payment createPayment = paymentClient.create(paymentCreateRequest);

            payment.addPaymentDetails(QR_CODE, createPayment.getPointOfInteraction().getTransactionData().getQrCode());

            paymentJpaRepository.save(PaymentEntity.toEntity(payment));
        } catch (Exception e) {
            throw new PaymentNotGeneratedException(e, "Error generating payment");
        }

        return payment;
    }

    @Override
    public boolean isType(Payment payment) {
        return QR_CODE.equalsIgnoreCase(payment.getType()) || PIX.equalsIgnoreCase(payment.getType());
    }
}
