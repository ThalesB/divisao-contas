package br.com.softexpert.divisaocontasapi.domain.assembler;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
import br.com.softexpert.divisaocontasapi.domain.request.MercadoPagoPixRequest;
import br.com.softexpert.divisaocontasapi.domain.request.Payer;

public class MercadoPagoPixRequestAssembler {

    public static MercadoPagoPixRequest buildResquest(ContaDTO conta, ItemDTO item){

        return MercadoPagoPixRequest.builder()
                .description("Criar pagamento pix")
                .payer(Payer.builder().email(item.getEmail()).first_name(item.getNomeConta()).last_name(item.getUltimoNome()).build())
                .payment_method_id("pix")
                .transaction_amount(item.getValorItem())
                .build();
    }
}
