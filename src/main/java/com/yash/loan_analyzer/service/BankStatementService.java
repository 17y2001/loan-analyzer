package com.yash.loan_analyzer.service;

import com.yash.loan_analyzer.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankStatementService {

    public double calculateTotalCredits(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType().equals("CREDIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateTotalDebits(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getType().equals("DEBIT"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}