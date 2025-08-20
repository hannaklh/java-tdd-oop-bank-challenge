package com.booleanuk.core;

public class Manager extends User {
    private Branch branch;

    public Manager(String name, int id, Branch branch) {
        super(name, id);
        this.branch = branch;
    }

    public Manager() {
    }
    public boolean decideOnOverdraft(Customer c, Account a) {
        return false;
    }
}
