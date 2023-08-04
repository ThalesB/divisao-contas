package br.com.softexpert.divisaocontasapi.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

@Getter
public enum GatewayEnum {

    MERCADO_PAGO("Mercado Pago", "MercadoPagoPaymentProcessor"),
    NONE("none", "none");

    private String description;
    private String implementationDescription;


    GatewayEnum(String description, String implementationDescription) {
        this.description = description;
        this.implementationDescription = implementationDescription;
    }

    public static String getImplementationByDescription(String description){
        return Arrays.stream(GatewayEnum.values()).filter(p -> Objects.equals(p.getDescription(), description)).findFirst().orElse(NONE).getImplementationDescription();    }
}
