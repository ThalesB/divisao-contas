package br.com.softexpert.divisaocontasapi.service;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
import br.com.softexpert.divisaocontasapi.domain.enums.GatewayEnum;
import br.com.softexpert.divisaocontasapi.domain.response.PaymentResponse;
import br.com.softexpert.divisaocontasapi.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DivisaoContasService {
    @Autowired
    private PaymentProcessorFactory paymentProcessorFactory;

    private List<Validator> validators;

    public DivisaoContasService(List<Validator> validators){
        this.validators = validators;
    }

    public List<ContaFinalDTO> dividirContas(DivisaoContaDTO contas){

        List<ContaFinalDTO> contasFinais = new ArrayList<>();

        if (!contas.getItems().isEmpty()) {

            List<ItemDTO> itemsTotais = getItemsPorNumero(contas);

            itemsTotais.forEach(item -> {

                BigDecimal valorFinal = getValorFinal(contas, itemsTotais.size(), item);

                try {
                    if (Objects.nonNull(contas.getConta().getCredencial())) {
                        PaymentResponse response = this.processPayment(contas.getConta(), item, GatewayEnum.getImplementationByDescription(contas.getConta().getGatewayPagamento()));

                        contasFinais.add(ContaFinalDTO.builder()
                                .nomeConta(item.getNomeConta())
                                .numeroConta(item.getNumeroConta())
                                .valorFinal(valorFinal)
                                .qrCodePix("data:image/png;base64,"+response.getQrCodeBase64())
                                .chavePix(contas.getConta().getPix())
                                .build());
                    } else {
                        throw new Exception();
                    }

                } catch (Exception e){

                    contasFinais.add(ContaFinalDTO.builder()
                            .nomeConta(item.getNomeConta())
                            .numeroConta(item.getNumeroConta())
                            .valorFinal(valorFinal)
                            .qrCodePix(null)
                            .chavePix(contas.getConta().getPix())
                            .build());
                }
            });
        }

        this.validators.forEach(validator -> validator.validate(contasFinais, contas.getConta()));

        return contasFinais;
    }

    private List<ItemDTO> getItemsPorNumero(DivisaoContaDTO contas) {

        Map<Integer, List<ItemDTO>> itemsPorNumeroConta = contas.getItems().stream()
                .collect(Collectors.groupingBy(ItemDTO::getNumeroConta));

        return itemsPorNumeroConta.entrySet().stream()
                .map(entry -> {
                    Integer numeroConta = entry.getKey();
                    List<ItemDTO> itemsMesmaConta = entry.getValue();

                    BigDecimal somaValoresConta = itemsMesmaConta.stream()
                            .map(ItemDTO::getValorItem)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    String nomeConta = itemsMesmaConta.get(0).getNomeConta();
                    String nomeItem = itemsMesmaConta.get(0).getNomeItem();
                    String email = itemsMesmaConta.get(0).getEmail();
                    String ultimoNome = itemsMesmaConta.get(0).getUltimoNome();

                    return new ItemDTO(nomeConta, numeroConta, somaValoresConta, nomeItem, email, ultimoNome);
                })
                .collect(Collectors.toList());
    }

    private BigDecimal getValorFinal(DivisaoContaDTO contas, Integer tamanhoLista, ItemDTO item) {

        BigDecimal valorDesconto = this.calculoDivisaoTaxas(contas.getConta().getDescontos(), tamanhoLista);
        BigDecimal valorTaxa = this.calculoDivisaoTaxas(contas.getConta().getValorTaxaExtra(), tamanhoLista);
        BigDecimal valorEntrega = this.calculoDivisaoTaxas(contas.getConta().getValorEntrega(), tamanhoLista);

        BigDecimal valorFinal = item.getValorItem().add(valorEntrega).add(valorTaxa).subtract(valorDesconto);
        BigDecimal valorComTaxaDeAtendimento = valorFinal.multiply(new BigDecimal("0.1")).add(valorFinal);

        return contas.getConta().getTaxaAtendimento() ? valorComTaxaDeAtendimento.setScale(2, RoundingMode.HALF_UP) : valorFinal.setScale(2, RoundingMode.HALF_UP);
    }

    private BigDecimal calculoDivisaoTaxas(BigDecimal taxa, Integer tamanhoLista){

        return Objects.nonNull(taxa) ? taxa.divide(BigDecimal.valueOf(tamanhoLista)) : BigDecimal.ZERO;
    }

    public PaymentResponse processPayment(ContaDTO conta, ItemDTO item , String paymentType) {

        PaymentProcessor paymentProcessor = paymentProcessorFactory.createPaymentProcessor(paymentType);
        return paymentProcessor.processPayment(conta, item);
    }
}
