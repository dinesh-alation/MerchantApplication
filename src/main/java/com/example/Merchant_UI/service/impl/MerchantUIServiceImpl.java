package com.example.Merchant_UI.service.impl;

import com.example.Merchant_UI.DTO.MerchantDTO;
import com.example.Merchant_UI.service.MerchantUIservice;
import com.example.Merchant_UI.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantUIServiceImpl implements MerchantUIservice {



    @Autowired
    HttpUtils httpUtils;

    @Override
    public ResponseEntity<String> createMerchant(MerchantDTO merchantDTO) {
        String response = (String) httpUtils.postAPICall(merchantDTO, "http://localhost:8080/merchant/register");
        return null;
    }

}
