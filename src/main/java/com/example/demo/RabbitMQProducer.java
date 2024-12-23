package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final AmqpTemplate amqpTemplate;
    private final String exchange = "test_exchange";
    private final String routingKey = "test_routingKey";

    @Autowired
    public RabbitMQProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void sendMessage(String message) {
        amqpTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Message Sent: " + message);
    }
}
