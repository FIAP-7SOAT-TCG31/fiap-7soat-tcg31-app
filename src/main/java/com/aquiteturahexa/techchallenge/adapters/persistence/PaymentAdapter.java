package com.aquiteturahexa.techchallenge.adapters.persistence;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.PreferenceBackUrlsRequest;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.resources.preference.Preference;

import jakarta.servlet.http.HttpServletResponse;

public class PaymentAdapter {
    private String accessToken = "";

    private PreferenceClient client = new PreferenceClient();

    public String getFakeCheout() {

        MercadoPagoConfig.setAccessToken(accessToken);
        try {
            PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                    .id("")
                    .title("")
                    .quantity(1)
                    .unitPrice(new BigDecimal("10"))
                    .currencyId("BRL")
                    .build();

            List<PreferenceItemRequest> items = new ArrayList<>();
            items.add(itemRequest);

            PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("http://test.com/success")
                    .failure("http://test.com/failure")
                    .pending("http://test.com/pending")
                    .build();

            PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                    .backUrls(backUrls)
                    .items(items)
                    .build();

            Preference preference = client.create(preferenceRequest);

            return preference.getInitPoint();

        } catch (Exception e) {
            return e.getMessage();

        }
    }

    public void paymentChekout(HttpServletResponse response) throws IOException {

        response.sendRedirect(getFakeCheout());
    }

}
