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

        BigDecimal amount = new BigDecimal(123);
        Assertions.assertEquals(amount +" was deposited to your account" , savings.deposit(amount));
    }
    @Test
    public void shouldWithdraw() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1, new BigDecimal(1000));
        BigDecimal amount = new BigDecimal(100);


        Assertions.assertEquals(amount +" was withdrawn from your account" , savings.withdraw(amount));
    }
    @Test
    public void shouldNotWithdraw() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1, new BigDecimal(1000));

        BigDecimal amount = new BigDecimal(100);

        Assertions.assertEquals("There is not enough balance in your account. Balance: "+savings.getBalance() , savings.withdraw(amount));
    }
    @Test
    public void shouldGenerateBankStatements() {
        Customer customer = new Customer("Hanna Håkansson", 1);
        Account savings = new SavingsAccount(customer, 1, new BigDecimal(1000));

        BigDecimal amount = new BigDecimal(100);
        savings.deposit(amount);
        savings.withdraw(amount);

        Assertions.assertEquals("date\t||\tcredit\t||\tdebit\t||\t balance\n14/01/12\t||\t100\t1100", savings.generateBankStatements());
    }

}
