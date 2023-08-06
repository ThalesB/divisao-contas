package br.com.softexpert.divisaocontasapi.validator;


import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.feature.ScenarioFactory;
import br.com.softexpert.divisaocontasapi.validator.CalculoValidator;
import br.com.softexpert.divisaocontasapi.validator.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class CalculoValidatorTest {

    @InjectMocks
    CalculoValidator validator;


    @Test
    public void validate_ExpectedSucess() {

        assertDoesNotThrow(() -> {
            this.validator.validate(List.of(ScenarioFactory.NEW_CONTA_FINAL_DTO), ScenarioFactory.NEW_CONTA_DTO);
        });
    }

    @Test
    public void validate_ExpectedBusinessException() throws BusinessException {

        ContaDTO contas = ScenarioFactory.NEW_CONTA_DTO;
        contas.setValorTotal(BigDecimal.ONE);
        assertThrows(BusinessException.class, () -> {
            this.validator.validate(List.of(ScenarioFactory.NEW_CONTA_FINAL_DTO), contas);
        });
    }
}
