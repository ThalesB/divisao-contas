package br.com.softexpert.divisaocontasapi.domain.enums;

import lombok.Getter;

import java.util.Arrays;
@Getter
public enum GatewayEnum {

    MERCADO_PAGO("MercadoPago", "MercadoPagaoPixProcessor"),
    NONE("none", "none");

    private String description;
    private String implementationDescription;


    GatewayEnum(String description, String implementationDescription) {
        this.description = description;
        this.implementationDescription = description;
    }

    public String getImplementationByDescription(String description){
        return Arrays.stream(GatewayEnum.values()).filter(p -> p.getDescription() == description).findFirst().orElse(NONE).getImplementationDescription();    }
}
