package com.yash.loan_analyzer.controller;

import com.yash.loan_analyzer.model.Transaction;
import com.yash.loan_analyzer.service.BankStatementService;
import com.yash.loan_analyzer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bank")
public class BankStatementController {

    @Autowired
    private KafkaProducerService kafkaProducerService ;

    @Autowired
    private BankStatementService bankStatementService ;

    @PostMapping("/analyze")
    public Map<String, Double> analyze(@RequestBody List<Transaction> transactions){
        double credits = bankStatementService.calculateTotalCredits(transactions);
        double debits = bankStatementService.calculateTotalDebits(transactions);

        bankStatementService.saveAll(transactions);

        kafkaProducerService.sendStatement("Statement received with " + transactions.size() + " transactions");

        return Map.of(
                "totalCredits", credits,
                "totalDebits", debits,
                "netBalance", credits - debits
        );
    }
}
