package br.com.softexpert.divisaocontasapi.controller;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import br.com.softexpert.divisaocontasapi.service.DivisaoContasService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@RequestMapping("/divisao-contas")
public class DivisaoContasController {

    private DivisaoContasService divisaoContasService;

    public DivisaoContasController(DivisaoContasService divisaoContasService){
        this.divisaoContasService = divisaoContasService;
    }

    @PostMapping
    public ResponseEntity<List<ContaFinalDTO>> dividirContas(@RequestBody DivisaoContaDTO contas){

        return ResponseEntity.ok().body(this.divisaoContasService.dividirContas(contas));
    }
}
