package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    private final RabbitMQProducer rabbitMQProducer;

    @Autowired
    public RabbitMQController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        rabbitMQProducer.sendMessage(message);
        return "Message sent to RabbitMQ: " + message;
    }
}
