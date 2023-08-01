package br.com.softexpert.divisaocontasapi.domain.request;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MercadoPagoPixRequest {

    private BigDecimal transaction_amount;
    private String payment_method_id;
    private Payer payer;
    private String description;
}
