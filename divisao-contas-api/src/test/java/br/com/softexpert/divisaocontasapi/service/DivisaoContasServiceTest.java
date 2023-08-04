import br.com.softexpert.divisaocontasapi.controller.client.MercadoPagoClient;
import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.feature.ScenarioFactory;
import br.com.softexpert.divisaocontasapi.service.DivisaoContasService;
import br.com.softexpert.divisaocontasapi.service.MercadoPagoPaymentProcessor;
import br.com.softexpert.divisaocontasapi.service.PaymentProcessor;
import br.com.softexpert.divisaocontasapi.service.PaymentProcessorFactory;
import br.com.softexpert.divisaocontasapi.validator.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DivisaoContasServiceTest {

    @Mock
    private PaymentProcessorFactory paymentProcessorFactory;

    @Mock
    private MercadoPagoPaymentProcessor mercadoPagoPaymentProcessor;

    @Mock
    private PaymentProcessor paymentProcessor;

    @Mock
    private MercadoPagoClient mercadoPagoClient;

    @Mock
    private List<Validator> validators;

    @InjectMocks
    private DivisaoContasService service;

    @Test
    public void dividirContas_ExpectedSucess() throws Exception {
        // Configurar o comportamento esperado do paymentProcessorFactory

        when(paymentProcessorFactory.createPaymentProcessor("MercadoPagoPaymentProcessor"))
                .thenReturn(mercadoPagoPaymentProcessor);

        // Restante do código do teste
        List<ContaFinalDTO> contasFinais = this.service.dividirContas(ScenarioFactory.NEW_CONTAGERAL_DTO);

        assertThat(contasFinais).isNotEmpty();
    }
}