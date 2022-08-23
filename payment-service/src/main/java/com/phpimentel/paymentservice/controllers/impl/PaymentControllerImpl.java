package com.phpimentel.paymentservice.controllers.impl;

import com.phpimentel.paymentservice.controllers.PaymentController;
import com.phpimentel.paymentservice.models.Payment;
import com.phpimentel.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
        this.paymentService.sendPayment(payment);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
