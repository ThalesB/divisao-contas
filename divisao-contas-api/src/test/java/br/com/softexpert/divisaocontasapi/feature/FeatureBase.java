package br.com.softexpert.divisaocontasapi.feature;

import br.com.softexpert.divisaocontasapi.domain.DTO.ContaFinalDTO;
import br.com.softexpert.divisaocontasapi.domain.DTO.DivisaoContaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class FeatureBase {

    @Autowired
    protected TestRestTemplate template;


    protected Integer httpCodeExpected;

    @LocalServerPort
    protected int port;

    protected ResponseEntity<List<ContaFinalDTO>> responseEntityExpected;

    public FeatureBase() {

    }

    protected ResponseEntity<List<ContaFinalDTO>> postDivisaoContas(DivisaoContaDTO conta) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<DivisaoContaDTO> body = new HttpEntity<DivisaoContaDTO>(conta, headers);
        String url = String.format("http://localhost:8080/divisao-contas", port);
        // Definindo o tipo de retorno como uma lista de ContaFinalDTO
        ParameterizedTypeReference<List<ContaFinalDTO>> responseType =
                new ParameterizedTypeReference<List<ContaFinalDTO>>() {};

        return template.exchange(url, HttpMethod.POST, body, responseType);
    }
}