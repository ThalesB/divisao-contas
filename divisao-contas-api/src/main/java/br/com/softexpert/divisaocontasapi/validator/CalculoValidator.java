package br.com.softexpert.divisaocontasapi.validator;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.validator.exception.BusinessException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class CalculoValidator implements Validator{

    @Override
    public void validate(List<ContaFinalDTO> contaFinal, ContaDTO contaInicial) {

        BigDecimal valorTotalInicial = contaInicial.getValorTotal().setScale(2, RoundingMode.HALF_UP);

        BigDecimal valorTotalFinal = BigDecimal.ZERO;

        for (ContaFinalDTO conta : contaFinal) {
            valorTotalFinal = valorTotalFinal.add(conta.getValorFinal());
        }

        valorTotalFinal = valorTotalFinal.setScale(2, RoundingMode.HALF_UP);

        if (!valorTotalFinal.equals(valorTotalInicial)) {
            throw new BusinessException("Valor total final está inválido. Valor final: %.2f , valor inicial: %.2f", valorTotalFinal, valorTotalInicial);
        }
    }
}
