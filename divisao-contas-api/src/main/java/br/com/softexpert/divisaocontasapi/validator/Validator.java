package br.com.softexpert.divisaocontasapi.validator;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;

import java.util.List;

public interface Validator {

    void validate(List<ContaFinalDTO> contaFinal, ContaDTO conta);
}
