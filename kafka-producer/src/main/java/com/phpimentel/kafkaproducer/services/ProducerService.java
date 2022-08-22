package com.phpimentel.kafkaproducer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        this.kafkaTemplate.send("str-topic", message).addCallback(
                success -> {
                    if (Objects.nonNull(success)) {
                        log.info("Send message with success {}", message);
                        log.info("Partition {}", success.getRecordMetadata().partition());
                        log.info("Offset {}", success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Error send message")
        );
    }
}
