package br.com.softexpert.divisaocontasapi.domain.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DivisaoContaDTO {

    private List<ItemDTO> items = new ArrayList<ItemDTO>();
    private ContaDTO conta;
}
