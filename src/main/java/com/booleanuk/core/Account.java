package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private Customer customer;
    private int id;
    private List<Transaction> transactions;
    private int transactionCount = 1;
    private boolean canBeOverdrafted = false;
    private Branch branch;

    public Account(Customer customer, int id) {
        this.customer = customer;
        this.id = id;
        this.transactions = new ArrayList<>();
    }
    public Account(Customer customer, int id, Branch branch) {
        this.customer = customer;
        this.id = id;
        this.branch = branch;
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

    public String deposit(double transAmount){
        Transaction trans = new Transaction(this.transactionCount, LocalDate.now(), transAmount, this);

        this.transactionCount++;
        this.transactions.add(trans);
        return transAmount + " has been deposited to your account " + this.id;
    }
    public String withdraw(double transAmount){

        if (calculateBalance()>=transAmount || canBeOverdrafted) {
            Transaction trans = new Transaction(this.transactionCount, LocalDate.now(), -transAmount,this);
            this.transactionCount++;
            this.transactions.add(trans);
            return transAmount + " has been withdrawn from your account " + this.id;

        } else
            return "There are not enough funds on your account.";
    }
    public String generateBankStatements() {

        String returnString = "date\t\t||\tcredit\t||\tdebit\t||\tbalance\n";
        double currentBalance = 0;

        for (Transaction trans : transactions) {
             currentBalance += trans.getTransAmount();
            if (trans.getTransAmount() <0) {
                returnString += trans.getDate().toString() + "\t||\t" + (trans.getTransAmount()*-1)+"\t\t||\t\t||\t"+currentBalance+"\n";
            } else
                returnString += trans.getDate().toString() + "\t||\t\t\t||\t" + trans.getTransAmount()+"\t||\t"+currentBalance+"\n";


        }
        return returnString;
    }
    public boolean requestOverdraft() {
        this.canBeOverdrafted = branch.getManager().decideOnOverdraft(this);
        return this.canBeOverdrafted;
    }
    public double calculateBalance() {
        double totalBalance = 0;
        for (Transaction trans : transactions){
            totalBalance += trans.getTransAmount();
        }
        return totalBalance;
    }
}
