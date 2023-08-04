package br.com.softexpert.divisaocontasapi.domain.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Payer {
    private String first_name;
    private String last_name;
    private String email;
}
