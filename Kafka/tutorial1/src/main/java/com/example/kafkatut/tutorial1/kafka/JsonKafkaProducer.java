package com.example.kafkatut.tutorial1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.kafkatut.tutorial1.model.User;

@Service
public class JsonKafkaProducer {
        private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);

        private KafkaTemplate<String, User> kafkaTemplate;

        public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
                this.kafkaTemplate = kafkaTemplate;
        }

        public void sendMessageJson(User data) {

                logger.info(String.format("Added Message %s", data.toString()));
                Message<User> message = MessageBuilder
                                .withPayload(data)
                                .setHeader(KafkaHeaders.TOPIC, "my Header").build();
                this.kafkaTemplate.send(message);
        }

}
