package com.phpimentel.kafkaconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerListener {

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "containerFactory")
    public void listener(String message) {
        log.info("Receive message {}", message);
    }
}
