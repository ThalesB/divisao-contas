package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class DivisaoContaDTO {

    private List<ItemDTO> items = new ArrayList<ItemDTO>();
    private ContaDTO conta;
}
