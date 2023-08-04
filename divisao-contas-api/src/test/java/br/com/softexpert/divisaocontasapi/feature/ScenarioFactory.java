package br.com.softexpert.divisaocontasapi.feature;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;

import java.math.BigDecimal;
import java.util.List;

public class ScenarioFactory {

    public static final ContaDTO NEW_CONTA_DTO = newContaDTO();
    public static final ItemDTO NEW_ITEM_DTO = newItemDTO();
    public static final DivisaoContaDTO NEW_CONTAGERAL_DTO = newContaGeralDTO();

    private static DivisaoContaDTO newContaGeralDTO() {
        return DivisaoContaDTO.builder()
                .conta(newContaDTO())
                .items(List.of(newItemDTO()))
                .build();
    }

    private static ItemDTO newItemDTO() {
        return ItemDTO.builder()
                .email("teste@email.com")
                .nomeItem("teste")
                .nomeConta("teste")
                .numeroConta(1)
                .ultimoNome("teste")
                .nomeItem("teste")
                .valorItem(BigDecimal.TEN)
                .build();
    }

    private static ContaDTO newContaDTO() {
        return ContaDTO.builder()
                .credencial("testeCredencial")
                .descontos(BigDecimal.ZERO)
                .gatewayPagamento("Mercado Pago")
                .pix("pixTeste")
                .valorEntrega(BigDecimal.ZERO)
                .taxaAtendimento(false)
                .valorTotal(BigDecimal.TEN)
                .valorTaxaExtra(BigDecimal.ZERO)
                .build();
    }

}
