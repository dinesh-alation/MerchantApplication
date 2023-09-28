package com.example.Merchant_UI.service.impl;

import com.example.Merchant_UI.DTO.PaymentDTO;
import com.example.Merchant_UI.service.Paymentservice;
import com.example.Merchant_UI.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements Paymentservice {


    @Autowired
    HttpUtils httpUtils;

    @Override
    public ResponseEntity<String> makePayment(PaymentDTO paymentDTO) {
        String response=(String) httpUtils.postAPICall(paymentDTO,"http://localhost:8080/payment-gateway/makePayment");
        return null;
    }

    @Override
    public ResponseEntity<String> checkPaymentStatus(String paymentId) {
        String response=(String) httpUtils.getAPICall("http://localhost:8080/payment-gateway/status/"+paymentId);
        return null;
    }


}
