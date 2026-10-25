package com.yash.loan_analyzer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendStatement(String message) {
        kafkaTemplate.send("bank-statements", message);
        System.out.println("Sent to Kafka: " + message);
    }
}