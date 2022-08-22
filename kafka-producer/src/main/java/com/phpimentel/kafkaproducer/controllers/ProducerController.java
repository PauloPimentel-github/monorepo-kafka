package com.phpimentel.kafkaproducer.controllers;

import com.phpimentel.kafkaproducer.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        this.producerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
