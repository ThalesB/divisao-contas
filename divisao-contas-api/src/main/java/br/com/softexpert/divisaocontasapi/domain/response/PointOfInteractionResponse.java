package br.com.softexpert.divisaocontasapi.domain.response;

import lombok.Getter;

@Getter
public class PointOfInteractionResponse {

    private String type;
    private TransactionDataResponse transaction_data;
}
