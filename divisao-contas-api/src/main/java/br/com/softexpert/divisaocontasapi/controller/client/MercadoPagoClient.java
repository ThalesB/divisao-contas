package br.com.softexpert.divisaocontasapi.controller.client;

import br.com.softexpert.divisaocontasapi.domain.request.MercadoPagoPixRequest;
import br.com.softexpert.divisaocontasapi.domain.response.MercadoPagoPixResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "mercadoPagoClient", url = "https://api.mercadopago.com/v1")
public interface MercadoPagoClient {

    @PostMapping("/payments")
    MercadoPagoPixResponse criarPagamentoPix(@RequestHeader("Authorization") String token, @RequestBody MercadoPagoPixRequest request);
}
