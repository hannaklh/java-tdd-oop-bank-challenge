package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate date;
    private BigDecimal amount;
    private String type;
    private BigDecimal balance;
    private Account account;

    public Transaction(int id, LocalDate date, BigDecimal amount, String type, BigDecimal balance, Account account) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.balance = balance;
        this.account = account;
    }
    public Transaction() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
