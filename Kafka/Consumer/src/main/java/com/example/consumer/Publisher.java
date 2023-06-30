package com.example.consumer;

import org.springframework.kafka.core.KafkaTemplate;

public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "return-topic";
    public Publisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLength(String length) {
        this.kafkaTemplate.send(TOPIC, length);
    }
}
