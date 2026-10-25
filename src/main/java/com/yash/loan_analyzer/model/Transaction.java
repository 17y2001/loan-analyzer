package com.yash.loan_analyzer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id ;

    private String description;
    private double amount;
    private String type; // "CREDIT" or "DEBIT"
    private LocalDate date;
}