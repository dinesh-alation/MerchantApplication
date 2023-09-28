package com.example.Merchant_UI.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private Long merchantId;
    private BigDecimal amount;
    private String currency;
    private String orderId;


}
