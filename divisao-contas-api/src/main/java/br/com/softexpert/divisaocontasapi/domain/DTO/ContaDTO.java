package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
public class ContaDTO {

    @NotNull(message = "O nome da conta é obrigatório para validação do cálculo")
    private BigDecimal valorTotal;

    @NotNull(message = "O nome da conta é obrigatório para geração do cálculo")
    private BigDecimal valorTaxaExtra;

    @NotNull(message = "O nome da conta é obrigatório para geração do cálculo")
    private Boolean taxaAtendimento;

    @NotNull(message = "O nome da conta é obrigatório para geração do cálculo")
    private BigDecimal valorEntrega;

    @NotNull(message = "O nome da conta é obrigatório para geração do cálculo")
    private BigDecimal descontos;

    @NotNull(message = "A chave pix é obrigatória como uma alternativa de pagamento")
    private String pix;

    private String credencial;

    private String gatewayPagamento;
}
