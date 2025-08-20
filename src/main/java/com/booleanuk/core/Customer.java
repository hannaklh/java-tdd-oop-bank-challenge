package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int id;
    private List<Account> accounts;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        this.accounts = new ArrayList<>();
    }

    public Customer() {}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String createAccount( Account account) {
        this.accounts.add(account);
        return "Account "+account.getId()+" was added to " +this.name;
    }
}
