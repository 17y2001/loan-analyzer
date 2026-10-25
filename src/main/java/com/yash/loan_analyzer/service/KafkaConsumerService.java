package com.yash.loan_analyzer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "bank-statements", groupId = "loan-analyzer-group")
    public void consume(String message){
        System.out.println("Received from kafka: " + message);
        System.out.println("Processing bank statement....") ;
    }
}
