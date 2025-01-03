package com.project.bankapp.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    private String type;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private com.project.bankapp.model.Account account;

    public Transaction() {
    }

    public Transaction(BigDecimal amount, String type, LocalDateTime timestamp, com.project.bankapp.model.Account account) {
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
        this.account = account;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public com.project.bankapp.model.Account getAccount() {
        return account;
    }

    public void setAccount(com.project.bankapp.model.Account account) {
        this.account = account;
    }
}

