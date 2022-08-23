package com.phpimentel.paymentservice.models;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}
