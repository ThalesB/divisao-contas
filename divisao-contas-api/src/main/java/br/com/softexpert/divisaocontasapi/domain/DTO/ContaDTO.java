package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class ContaDTO {

    @NotNull(message = "O nome da conta � obrigat�rio para valida��o do c�lculo")
    private BigDecimal valorTotal;

    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do c�lculo")
    private BigDecimal valorTaxaExtra;

    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do c�lculo")
    private Boolean taxaAtendimento;

    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do c�lculo")
    private BigDecimal valorEntrega;

    @NotNull(message = "O nome da conta � obrigat�rio para gera��o do c�lculo")
    private BigDecimal descontos;

    @NotNull(message = "A chave pix � obrigat�ria como uma alternativa de pagamento")
    private String pix;

    private String credencial;

    private String gatewayPagamento;
}
