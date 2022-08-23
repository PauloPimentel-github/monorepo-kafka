package com.phpimentel.jsonconsumer.listeners;

import com.phpimentel.jsonconsumer.models.Payment;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Slf4j
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("Recebi o pagamento {}", payment.toString());
        sleep(2000);

        log.info("Validando fraude...");
        sleep(2000);

        log.info("Compra aprovada...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        sleep(3000);
        log.info("Gerando PDF do produto de id {}...", payment.getId());
        sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "send-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        sleep(3000);
        log.info("Enviando E-mail de confirmação...");
    }
}
