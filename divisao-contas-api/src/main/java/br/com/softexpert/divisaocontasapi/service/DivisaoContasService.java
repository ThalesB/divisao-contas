package br.com.softexpert.divisaocontasapi.service;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DivisaoContasService {


    public void dividirContas(DivisaoContaDTO contas){

        List<ContaFinalDTO> contasFinais = new ArrayList<>();

        if (!contas.getItems().isEmpty()) {

            //Separando os items por número da conta
            Map<Integer, ItemDTO> somaPorNumeroConta = contas.getItems().stream()
                    .collect(Collectors.groupingBy(ItemDTO::getNumeroConta,
                            Collectors.reducing(BigDecimal.ZERO, ItemDTO::getValorItem, BigDecimal::add)))
                    .entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            entry -> new ItemDTO(entry.getKey(), contas.getItems().stream()
                                    .filter(item -> item.getNumeroConta().equals(entry.getKey()))
                                    .findFirst()
                                    .orElseThrow()
                                    .getNomeConta(), entry.getValue())));

            List<ItemDTO> itemsTotais = new ArrayList<>(somaPorNumeroConta.values());

            itemsTotais.forEach(item -> {

                BigDecimal valorFinal = getValorFinal(contas, itemsTotais.size(), item);

                // implementação pix
                String linkPix = "url";

                        contasFinais.add(ContaFinalDTO.builder()
                               .nomeConta(item.getNomeConta())
                               .numeroConta(item.getNumeroConta())
                               .valorFinal(valorFinal)
                               .linkPix(linkPix)
                                .build());
            });
        }
    }

    private BigDecimal getValorFinal(DivisaoContaDTO contas, Integer tamanhoLista, ItemDTO item) {

        BigDecimal valorDesconto = this.calculoDivisaoTaxas(contas.getConta().getDescontos(), tamanhoLista);
        BigDecimal valorTaxa = this.calculoDivisaoTaxas(contas.getConta().getValorTaxaExtra(), tamanhoLista);
        BigDecimal valorEntrega = this.calculoDivisaoTaxas(contas.getConta().getValorEntrega(), tamanhoLista);

        BigDecimal valorFinal = item.getValorItem().add(valorEntrega).add(valorTaxa).subtract(valorDesconto);

        return contas.getConta().getTaxaAtendimento() ? valorFinal.multiply(new BigDecimal("0.10")) : valorFinal;
    }

    private BigDecimal calculoDivisaoTaxas(BigDecimal taxa, Integer tamanhoLista){

        return Objects.nonNull(taxa) ? taxa.divide(BigDecimal.valueOf(tamanhoLista)) : BigDecimal.ZERO;
    }

}
