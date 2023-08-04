package br.com.softexpert.divisaocontasapi.service;

import br.com.softexpert.divisaocontasapi.controller.client.MercadoPagoClient;
import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
import br.com.softexpert.divisaocontasapi.domain.assembler.MercadoPagoPixRequestAssembler;
import br.com.softexpert.divisaocontasapi.domain.request.MercadoPagoPixRequest;
import br.com.softexpert.divisaocontasapi.domain.response.MercadoPagoPixResponse;
import br.com.softexpert.divisaocontasapi.domain.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class MercadoPagoPaymentProcessor implements PaymentProcessor{

    private MercadoPagoClient mercadoPagoClient;

    public MercadoPagoPaymentProcessor(MercadoPagoClient mercadoPagoClient){
        this.mercadoPagoClient = mercadoPagoClient;
    }

    @Override
    public PaymentResponse processPayment(ContaDTO conta, ItemDTO item) {

        MercadoPagoPixRequest request = MercadoPagoPixRequestAssembler.buildResquest(conta, item);

        MercadoPagoPixResponse response = this.mercadoPagoClient.criarPagamentoPix("Bearer " + conta.getCredencial(), request);

        return new PaymentResponse(response.getPoint_of_interaction().getTransaction_data().getQr_code(), response.getPoint_of_interaction().getTransaction_data().getQr_code_base64());
    }
}
