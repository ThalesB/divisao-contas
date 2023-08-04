package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDTO {
    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do pagamento")
    private String nomeConta;
    @NotNull(message = "O n�mero da conta � obrigat�rio para separa��o do valor")
    private Integer numeroConta;
    @NotNull(message = "O valor do item � obrigat�rio para separa��o de valor")
    private BigDecimal valorItem;

    private String nomeItem;

    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do pagamento")
    private String email;

    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do pagamento")
    private String ultimoNome;

    public ItemDTO(Integer numeroConta, String nomeConta, BigDecimal valorItem){
        this.numeroConta = numeroConta;
        this.valorItem = valorItem;
        this.nomeConta = nomeConta;
    }
}