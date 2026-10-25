package com.yash.loan_analyzer.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Transaction {
    private String description;
    private double amount;
    private String type; // "CREDIT" or "DEBIT"
    private LocalDate date;
}