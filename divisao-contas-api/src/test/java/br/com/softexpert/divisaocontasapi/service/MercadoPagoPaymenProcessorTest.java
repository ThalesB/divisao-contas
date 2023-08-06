package br.com.softexpert.divisaocontasapi.service;

import br.com.softexpert.divisaocontasapi.controller.client.MercadoPagoClient;
import br.com.softexpert.divisaocontasapi.domain.response.PaymentResponse;
import br.com.softexpert.divisaocontasapi.feature.ScenarioFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MercadoPagoPaymenProcessorTest {

    @Mock
    MercadoPagoClient mercadoPagoClient;

    @InjectMocks
    MercadoPagoPaymentProcessor service;

    @Mock
    PaymentResponse response;

    @Test
    public void processPayment_expectedSucess(){

        given(mercadoPagoClient.criarPagamentoPix(any(), any())).willReturn(ScenarioFactory.NEW_MERCADO_PAGO_PIX_RESPONSE);

        PaymentResponse response = this.service.processPayment(ScenarioFactory.NEW_CONTA_DTO, ScenarioFactory.NEW_ITEM_DTO);

        assertThat(response).isNotNull();
        verify(mercadoPagoClient, atLeastOnce()).criarPagamentoPix(any(), any());
    }
}
