package com.booleanuk.core.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private List<Account> accounts;

    public Customer(String name, int id) {
        super(name, id);
        this.accounts = new ArrayList<>();
    }

    public Customer() {}

    public String createAccount( Account account) {
        this.accounts.add(account);
        return "Account "+account.getId()+" was added to " + super.getName();
    }

}
