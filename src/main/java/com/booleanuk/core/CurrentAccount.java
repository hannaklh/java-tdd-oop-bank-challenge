package com.booleanuk.core;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    public CurrentAccount(Customer customer, int id) {
        super(customer, id);
    }

    public CurrentAccount(Customer customer, int id, Branch branch) {
        super(customer, id, branch);
    }
    public CurrentAccount() {
    }
}
