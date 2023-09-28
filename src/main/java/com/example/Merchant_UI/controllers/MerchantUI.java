package com.example.Merchant_UI.controllers;

import com.example.Merchant_UI.DTO.MerchantDTO;
import com.example.Merchant_UI.service.MerchantUIservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/merchant")
public class MerchantUI {

    @Autowired
    private MerchantUIservice merchantUIservice;

    @PostMapping("/register")
    public ResponseEntity<String> registerMerchant(@RequestBody MerchantDTO merchantDTO) {
        return merchantUIservice.createMerchant(merchantDTO);

    }
}
