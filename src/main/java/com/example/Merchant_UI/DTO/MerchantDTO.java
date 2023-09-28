package com.example.Merchant_UI.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDTO {

    private Long merchantId;
    private String name;
    private String email;
    private String businessType;
    private String address;
    private String phone;


}
