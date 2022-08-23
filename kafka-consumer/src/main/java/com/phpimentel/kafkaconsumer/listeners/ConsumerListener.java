package com.phpimentel.kafkaconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerListener {

    @KafkaListener(groupId = "group-0", topics = "str-topic", containerFactory = "containerFactory")
    public void create(String message) {
        log.info("CREATE ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "containerFactory")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "containerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Receive message {}", message);
    }
}
