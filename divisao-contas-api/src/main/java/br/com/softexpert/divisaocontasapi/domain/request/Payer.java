package br.com.softexpert.divisaocontasapi.domain.request;

import lombok.Data;

@Data
public class Payer {
    private String first_name;
    private String last_name;
    private String email;
}
