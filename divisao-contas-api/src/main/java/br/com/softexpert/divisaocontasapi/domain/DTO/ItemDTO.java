package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemDTO {
    private String nomeConta;
    private Integer numeroConta;
    private BigDecimal valorItem;
    private String nomeItem;

    public ItemDTO(Integer numeroConta, String nomeConta, BigDecimal valorItem){
        this.numeroConta = numeroConta;
        this.valorItem = valorItem;
        this.nomeConta = nomeConta;
    }
}