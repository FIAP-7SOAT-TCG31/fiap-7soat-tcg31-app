package com.cleanarchitecture.techchallenge.infra.dataproviders.payment;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "mercadopago")
public class MercadoPagoProperties {

    private String token;
    private Boolean enabled;
    private String callbackUrl;
}
