package br.com.softexpert.divisaocontasapi.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionDataResponse {

    private String qr_code_base64;
    private String qr_code;
    private String ticket_url;
}
