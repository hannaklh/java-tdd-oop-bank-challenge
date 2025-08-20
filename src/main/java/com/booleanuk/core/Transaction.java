package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private int id;
    private LocalDate date;
    private double transAmount;
    private Account account;

    public Transaction(int id, LocalDate date, double transAmount, Account account) {
        this.id = id;
        this.date = date;
        this.transAmount = transAmount;
        this.account = account;
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

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
