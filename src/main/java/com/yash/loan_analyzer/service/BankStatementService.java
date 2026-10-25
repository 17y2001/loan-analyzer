package com.yash.loan_analyzer.service;

import com.yash.loan_analyzer.model.Transaction;
import com.yash.loan_analyzer.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class BankStatementService {

    @Autowired
    private TransactionRepository transactionRepository ;


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

    public void saveAll(List<Transaction> transactions) {
        transactionRepository.saveAll(transactions) ;
        System.out.println("Saved " + transactions.size() + " transactions to DB") ;
    }
}