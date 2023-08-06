package br.com.softexpert.divisaocontasapi.feature;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
import br.com.softexpert.divisaocontasapi.domain.request.MercadoPagoPixRequest;
import br.com.softexpert.divisaocontasapi.domain.request.Payer;
import br.com.softexpert.divisaocontasapi.domain.response.MercadoPagoPixResponse;
import br.com.softexpert.divisaocontasapi.domain.response.PointOfInteractionResponse;
import br.com.softexpert.divisaocontasapi.domain.response.TransactionDataResponse;

import java.math.BigDecimal;
import java.util.List;

public class ScenarioFactory {

    public static final ContaDTO NEW_CONTA_DTO = newContaDTO();
    public static final ItemDTO NEW_ITEM_DTO = newItemDTO();
    public static final DivisaoContaDTO NEW_CONTAGERAL_DTO = newContaGeralDTO();

    public static final MercadoPagoPixRequest NEW_MERCADO_PAGO_PIX_REQUEST = newMercadoPagaoPixRequest();

    public static final Payer NEW_PAYER = newPayer();

    public static final MercadoPagoPixResponse NEW_MERCADO_PAGO_PIX_RESPONSE = newMercadoPagoPixResponse();

    public static final PointOfInteractionResponse NEW_POINT_OF_INTERACTION = newPointOfInteraction();

    public static final TransactionDataResponse NEW_TRANSACTION_DATA = newTransactionData();

    public static final ContaFinalDTO NEW_CONTA_FINAL_DTO = newContaFinalDTO();

    private static ContaFinalDTO newContaFinalDTO() {
        return ContaFinalDTO.builder()
                .chavePix("teste")
                .valorFinal(BigDecimal.TEN)
                .numeroConta(1)
                .nomeConta("teste")
                .nomeConta("teste")
                .qrCodePix("teste")
                .build();
    }

    private static TransactionDataResponse newTransactionData() {
            return TransactionDataResponse.builder()
                    .qr_code("teste")
                    .qr_code_base64("teste")
                    .ticket_url("teste")
                    .build();
    }

    private static PointOfInteractionResponse newPointOfInteraction() {

        return PointOfInteractionResponse.builder()
                .transaction_data(newTransactionData())
                .type("teste")
                .build();

    }

    private static MercadoPagoPixResponse newMercadoPagoPixResponse() {
            return MercadoPagoPixResponse.builder()
                    .point_of_interaction(newPointOfInteraction())
                    .build();
    }

    private static Payer newPayer() {
        return Payer.builder()
                .last_name("teste")
                .first_name("teste")
                .email("teste@teste.com.br")
                .build();
    }

    private static MercadoPagoPixRequest newMercadoPagaoPixRequest() {
        return MercadoPagoPixRequest.builder()
                .description("teste")
                .transaction_amount(BigDecimal.TEN)
                .payer(newPayer())
                .payment_method_id("pix")
                .build();
    }

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
