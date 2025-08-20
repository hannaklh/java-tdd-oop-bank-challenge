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
        Account savings = new SavingsAccount(customer, 1, 1000);
        double amount = 100;


        Assertions.assertEquals(amount +" has been withdrawn from your account "+ savings.getId() , savings.withdraw(amount));
    }
    @Test
    public void shouldNotWithdraw() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1, 1000);

        double amount = 11000;

        Assertions.assertEquals("There are not enough funds on your account. Current balance: "+savings.getBalance() , savings.withdraw(amount));
    }
    @Test
    public void shouldGenerateBankStatements() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1, 1000);

        double amount = 100.0;
        savings.deposit(amount);
        savings.withdraw(amount);
        String string = "date\t\t||\tcredit\t||\tdebit\t||\tbalance\n2025-08-20\t||\t\t\t||\t100.0\t||\t1100.0\n2025-08-20\t||\t100.0\t\t||\t\t||\t1000.0\n";

       Assertions.assertEquals(string, savings.generateBankStatements());
    }

}
