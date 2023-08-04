package br.com.softexpert.divisaocontasapi.service;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
import br.com.softexpert.divisaocontasapi.domain.response.PaymentResponse;

public interface PaymentProcessor {

    PaymentResponse processPayment(ContaDTO conta, ItemDTO item);
}
