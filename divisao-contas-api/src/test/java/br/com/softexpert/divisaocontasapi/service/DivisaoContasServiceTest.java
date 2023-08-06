import br.com.softexpert.divisaocontasapi.controller.client.MercadoPagoClient;
import br.com.softexpert.divisaocontasapi.domain.DTO.ItemDTO;
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

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void getItemsPorNumero_ExpectedSucess(){

        List<ItemDTO> itemsPorNumero = this.service.getItemsPorNumero(ScenarioFactory.NEW_CONTAGERAL_DTO);

        assertThat(itemsPorNumero).isNotEmpty();
        assertThat(itemsPorNumero.size()).isEqualTo(1);
    }

    @Test
    public void getValorFinal_ExpectedSucess() {

        BigDecimal valorFinal = this.service.getValorFinal(ScenarioFactory.NEW_CONTAGERAL_DTO, 1, ScenarioFactory.NEW_ITEM_DTO);

        assertThat(valorFinal).isNotZero();
        assertThat(valorFinal).isNotNull();
    }

    @Test
    public void calculoDivisaoTaxa_ExpectedSucess(){

        BigDecimal valorTaxa = this.service.calculoDivisaoTaxas(BigDecimal.TEN, 1);

        assertThat(valorTaxa).isNotNull();
        assertThat(valorTaxa).isEqualTo(BigDecimal.TEN);
    }
}