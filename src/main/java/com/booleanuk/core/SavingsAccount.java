package com.booleanuk.core;

import java.math.BigDecimal;

public class SavingsAccount extends Account{
    public SavingsAccount(Customer customer, int id) {
        super(customer, id);
    }

    public SavingsAccount(Customer customer, int id, double balance) {
        super(customer, id, balance);
    }

    public SavingsAccount() {
    }
}
