package com.example.kafkatut.tutorial1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class kafkaProducer {

    private static final Logger Logger = LoggerFactory.getLogger(kafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        Logger.info(String.format("Message send %s", message));
        this.kafkaTemplate.send("topic1", message);
    }

}
