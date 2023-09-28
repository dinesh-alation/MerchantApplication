package com.example.Merchant_UI.controllers;


import com.example.Merchant_UI.DTO.PaymentDTO;
import com.example.Merchant_UI.service.Paymentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/")
public class PaymentGateway {

    @Autowired
    private Paymentservice paymentservice;

    @PostMapping("/makePayment")
    public ResponseEntity<?> makePayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentservice.makePayment(paymentDTO);    }

    @GetMapping("/status/{paymentCode}")
    public ResponseEntity<String> checkPaymentStatus(@PathVariable String paymentCode) {
        return paymentservice.checkPaymentStatus(paymentCode);
    }

}

