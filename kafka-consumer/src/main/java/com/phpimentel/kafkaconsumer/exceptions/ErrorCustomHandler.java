package com.phpimentel.kafkaconsumer.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.info("EXCEPTION_HANDLER ::: Capturei um erro");
        log.info("Headers ::: {}", message.getHeaders());
        log.info("Payload ::: {}", message.getPayload());
        log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
        log.error("Message Exception ::: {}", exception.getMessage());
        return null;
    }
}
