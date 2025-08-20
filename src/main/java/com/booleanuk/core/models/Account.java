package com.booleanuk.core.models;

import com.booleanuk.core.dto.TransactionResult;
import com.booleanuk.core.exceptions.InsufficientFundsException;
import com.booleanuk.core.exceptions.InvalidAmountException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Customer customer;
    private int id;
    private List<Transaction> transactions;
    private int transactionCount = 1;
    private boolean canBeOverdrafted = false;
    private Branch branch;
    private AccountType accountType;

    public Account(Customer customer, int id, AccountType accountType) {
        this.customer = customer;
        this.id = id;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }
    public Account(Customer customer, int id, Branch branch, AccountType accountType) {
        this.customer = customer;
        this.id = id;
        this.branch = branch;
        this.accountType = accountType;
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

    public TransactionResult deposit(BigDecimal transAmount){
        if (transAmount.compareTo(BigDecimal.ZERO) >= 0) {
            return new TransactionResult(false, "Amount must be more than 0");
        }

            Transaction trans = new Transaction(this.transactionCount, LocalDate.now(), transAmount, this, TransactionType.DEPOSIT);
            this.transactionCount++;
            this.transactions.add(trans);
        return new TransactionResult(true, "Deposit successful");


    }
    public TransactionResult withdraw(BigDecimal transAmount){

        if (transAmount.compareTo(BigDecimal.ZERO) <=0) {
            throw new InvalidAmountException("Amount must be more than 0");
        }
        if (calculateBalance().compareTo(transAmount) <0 && !canBeOverdrafted) {
            throw new InsufficientFundsException("Insufficient funds. Balance is at: " +calculateBalance().toString());
        }

            Transaction trans = new Transaction(this.transactionCount, LocalDate.now(), transAmount,this, TransactionType.WITHDRAWAL);
            this.transactionCount++;
            this.transactions.add(trans);
            return new TransactionResult(true, transAmount.toString()+ " have been withdrawn from you account");
    }
    public StringBuilder generateBankStatements() {

        StringBuilder returnString = new StringBuilder("date\t\t||\tcredit\t||\tdebit\t||\tbalance\n");
        BigDecimal currentBalance = new BigDecimal("0");

        for (Transaction trans : transactions) {
             currentBalance = currentBalance.add(trans.getTransAmount());
            if (trans.getType() == TransactionType.WITHDRAWAL)
                returnString.append(trans.getDate().toString() + "\t||\t" + trans.getTransAmount().toString()+"\t\t||\t\t||\t"+currentBalance+"\n");

            if (trans.getTransAmount().compareTo(BigDecimal.ZERO) >= 0)
                returnString.append(trans.getDate().toString() + "\t||\t\t\t||\t" + trans.getTransAmount()+"\t||\t"+currentBalance+"\n");


        }
        return returnString;
    }
    public boolean requestOverdraft() {
        this.canBeOverdrafted = branch.getManager().decideOnOverdraft(this);
        return this.canBeOverdrafted;
    }
    public BigDecimal calculateBalance() {
        BigDecimal totalBalance = new BigDecimal("0");
        for (Transaction trans : transactions){
            totalBalance = totalBalance.add(trans.getTransAmount());
        }
        return totalBalance;
    }
}
