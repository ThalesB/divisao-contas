package br.com.softexpert.divisaocontasapi.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentResponse {
    String qrCode;
    String qrCodeBase64;
}
