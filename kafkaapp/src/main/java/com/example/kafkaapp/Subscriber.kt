package com.example.kafkaapp

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Subscriber {


    val logger: Logger = LoggerFactory.getLogger(Subscriber::class.java)

        @KafkaListener(topics = ["length"], groupId = "lengths")
        fun consume(length: Int)  {
            logger.info("length -> $length")
        }
}