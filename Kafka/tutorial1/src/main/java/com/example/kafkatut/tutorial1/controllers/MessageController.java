package com.example.kafkatut.tutorial1.controllers;

import com.example.kafkatut.tutorial1.kafka.kafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

      private kafkaProducer kafkaProducer;

      public MessageController(kafkaProducer kafkaProducer) {
            this.kafkaProducer = kafkaProducer;
      }

      @GetMapping("/publish")
      public ResponseEntity<String> publish(@RequestParam("message") String message) {
            this.kafkaProducer.sendMessage(message);
            return ResponseEntity.ok("Message sent to user ");
      }
}
