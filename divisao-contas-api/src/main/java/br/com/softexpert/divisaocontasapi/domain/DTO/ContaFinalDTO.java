package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContaFinalDTO {

    private String nomeConta;
    private BigDecimal valorFinal;
    private Integer numeroConta;
    private String linkPix;
}
