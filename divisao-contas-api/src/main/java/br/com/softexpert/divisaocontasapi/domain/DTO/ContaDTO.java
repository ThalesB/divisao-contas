package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ContaDTO {

    private BigDecimal valorTotal;
    private BigDecimal valorTaxaExtra;
    private Boolean taxaAtendimento;
    private BigDecimal valorEntrega;
    private BigDecimal descontos;
    private String pix;
    private String credential;
    private String gatewayPagamento;
}
