package com.example.Merchant_UI.service;

import com.example.Merchant_UI.DTO.MerchantDTO;
import org.springframework.http.ResponseEntity;

public interface MerchantUIservice {
    ResponseEntity<String> createMerchant(MerchantDTO merchantDTO);
}
