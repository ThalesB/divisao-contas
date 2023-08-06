package br.com.softexpert.divisaocontasapi.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MercadoPagoPixResponse{

    private PointOfInteractionResponse point_of_interaction;
}
