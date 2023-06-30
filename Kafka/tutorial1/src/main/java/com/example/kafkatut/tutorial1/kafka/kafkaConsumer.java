package com.example.kafkatut.tutorial1.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class kafkaConsumer {
        private Logger logger = LoggerFactory.getLogger(getClass());

        @KafkaListener(topics = "topic1", groupId = "mygroup")
        public void listenTopic(String message) {
                logger.info(String.format("RECEIVED MESSAGE --> %s", message));
        }
}
