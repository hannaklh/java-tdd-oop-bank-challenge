package com.booleanuk.core.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate date;
    private BigDecimal transAmount;
    private Account account;
    private TransactionType type;

    public Transaction(int id, LocalDate date, BigDecimal transAmount, Account account, TransactionType transactionType) {
        this.id = id;
        this.date = date;
        this.transAmount = transAmount;
        this.account = account;
        this.type = transactionType;
    }
    public Transaction() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(BigDecimal transAmount) {
        this.transAmount = transAmount;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
