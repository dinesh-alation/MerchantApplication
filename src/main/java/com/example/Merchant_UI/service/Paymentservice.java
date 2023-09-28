package com.example.Merchant_UI.service;

import com.example.Merchant_UI.DTO.PaymentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface Paymentservice {

    ResponseEntity<?> makePayment(PaymentDTO paymentDTO);
    ResponseEntity<String> checkPaymentStatus(String paymentCode);
}
