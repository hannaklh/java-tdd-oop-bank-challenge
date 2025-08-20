package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private Customer customer;
    private int id;
    private List<Transaction> transactions;
    private BigDecimal balance = new BigDecimal(0);

    public Account(Customer customer, int id) {
        this.customer = customer;
        this.id = id;
        this.transactions = new ArrayList<>();
    }
    public Account(Customer customer, int id, BigDecimal balance) {
        this.customer = customer;
        this.id = id;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }
    public Account () {}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String deposit(BigDecimal amount){
        return "";
    }
    public String withdraw(BigDecimal amount){
        return "";
    }
    public String generateBankStatements() {
        return "";
    }
}
