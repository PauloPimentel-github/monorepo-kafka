package com.phpimentel.jsonconsumer.models;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUser;
    private Long idProduct;
    private String cardNumber;
}
