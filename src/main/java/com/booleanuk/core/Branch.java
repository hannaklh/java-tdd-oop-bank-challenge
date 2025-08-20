package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private Manager manager;
    private List<Account> accounts;

    public Branch(String name, Manager manager) {
        this.name = name;
        this.manager = manager;
        this.accounts = new ArrayList<>();
    }
    public Branch() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
