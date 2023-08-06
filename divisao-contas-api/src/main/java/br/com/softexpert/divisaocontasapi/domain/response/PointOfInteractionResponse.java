package br.com.softexpert.divisaocontasapi.domain.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PointOfInteractionResponse {

    private String type;
    private TransactionDataResponse transaction_data;
}
