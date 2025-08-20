package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {
    @Test
    public void shouldCreateAccount() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1);
        Account current = new CurrentAccount(customer, 2);
        Assertions.assertEquals("Account " + savings.getId()+ " was added to " + customer.getName(), customer.createAccount(savings));
        Assertions.assertEquals("Account " + current.getId()+ " was added to " + customer.getName(), customer.createAccount(current));

    }

    @Test
    public void shouldDeposit() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1);

        double amount = 100;
        Assertions.assertEquals(amount +" has been deposited to your account " + savings.getId() , savings.deposit(amount));
    }
    @Test
    public void shouldWithdraw() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Branch branch = new Branch();
        Manager manager = new Manager("Giovanni Capilletti", 1, branch);
        Account savings = new SavingsAccount(customer, 1, branch);

        branch.setManager(manager);
        branch.setName("Scranton");
        savings.deposit(1000);
        double amount = 1000;

        Assertions.assertEquals(amount +" has been withdrawn from your account "+ savings.getId() , savings.withdraw(amount));

        savings.deposit(1000);
        savings.deposit(7000);
        savings.deposit(12);
        savings.requestOverdraft();

        Assertions.assertEquals(1300000.0 +" has been withdrawn from your account "+ savings.getId() , savings.withdraw(1300000));


    }
    @Test
    public void shouldNotWithdraw() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Branch branch = new Branch();
        Manager manager = new Manager("Giovanni Capilletti", 1, branch);
        Account savings = new SavingsAccount(customer, 1, branch);


        branch.setManager(manager);
        branch.setName("Scranton");

        double amount = 11000;

        Assertions.assertEquals("There are not enough funds on your account.", savings.withdraw(amount));
    }
    @Test
    public void shouldGenerateBankStatements() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Branch branch = new Branch();
        Manager manager = new Manager("Giovanni Capilletti", 1, branch);
        Account savings = new SavingsAccount(customer, 1, branch);

        double amount = 1000;
        savings.deposit(amount);
        savings.withdraw(amount);
        String string = "date\t\t||\tcredit\t||\tdebit\t||\tbalance\n2025-08-20\t||\t\t\t||\t1000.0\t||\t1000.0\n2025-08-20\t||\t1000.0\t\t||\t\t||\t0.0\n";

       Assertions.assertEquals(string, savings.generateBankStatements());
    }
    @Test
    public void shouldCalculateBalance() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Branch branch = new Branch();
        Manager manager = new Manager("Giovanni Capilletti", 1, branch);
        Account savings = new SavingsAccount(customer, 1, branch);

        double amount = 100.0;
        savings.deposit(amount);
        savings.deposit(amount);
        savings.deposit(amount);
        savings.withdraw(amount);
        Assertions.assertEquals(200.0, savings.calculateBalance());
    }




}
