package com.example.kafkaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(value = "/archieve")
public class Controller {

    private final Publisher producer;

    @Autowired
    public Controller(Publisher producer) {
        this.producer = producer;
    }

    @GetMapping
    public void sendMessage(@RequestParam("message") String message) {
        StringBuilder sb = new StringBuilder(message);
        sb.reverse();
        message = sb.toString();
        System.out.println("-------------00000000000000000000");
        this.producer.sendMessage(message);
    }





//    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public String hello(@RequestBody String body) {
//        System.out.println("Body" + body);
//        StringBuilder sb = new StringBuilder(body);
//        sb.reverse();
//        return sb.toString();
//    }
}
