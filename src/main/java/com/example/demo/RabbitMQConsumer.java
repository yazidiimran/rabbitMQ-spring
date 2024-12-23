package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = "test_queue")
    public void receiveMessage(String message) {
        System.out.println("Message Received: " + message);
    }
}
