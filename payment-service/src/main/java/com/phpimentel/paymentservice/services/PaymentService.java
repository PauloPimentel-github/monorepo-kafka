package com.phpimentel.paymentservice.services;

import com.phpimentel.paymentservice.models.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
