package br.com.softexpert.divisaocontasapi.controller;

import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import br.com.softexpert.divisaocontasapi.service.DivisaoContasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/divisao-contas")
public class DivisaoContasController {

    private DivisaoContasService divisaoContasService;

    public DivisaoContasController(DivisaoContasService divisaoContasService){
        this.divisaoContasService = divisaoContasService;
    }

    @PostMapping
    public ResponseEntity<Object> dividirContas(@RequestBody DivisaoContaDTO contas){

        this.divisaoContasService.dividirContas(contas);
        return ResponseEntity.ok(Object.class);
    }
}
