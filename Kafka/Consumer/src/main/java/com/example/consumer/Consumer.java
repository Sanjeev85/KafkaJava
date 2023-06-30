package com.example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final KafkaTemplate<String , Integer> kafkaTemplate;
    private final String TOPIC = "return-topic";
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public Consumer(KafkaTemplate<String, Integer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @KafkaListener(topics = "custom-topic", groupId = "default")
    public void receiveMessage(String message) {
        logger.info(String.format("data ----> %s", message));
        this.kafkaTemplate.send(TOPIC, message.length());
    }
}
