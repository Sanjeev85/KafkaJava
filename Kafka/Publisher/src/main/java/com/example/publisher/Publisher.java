package com.example.publisher;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/producer")
public class Publisher {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC = "custom-topic";
    private final Logger logger = LoggerFactory.getLogger(Publisher.class);


    public Publisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(value = "/send", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void sendMessage(@RequestBody String message) {
        this.kafkaTemplate.send(TOPIC, message);
    }

    @KafkaListener(topics = "return-topic", groupId = "default1")
    public void receiveMessage(Integer message) {
        logger.info(String.format("data ----> %s", message));
    }
}
